package com.lianghuawang.cottonfarmer.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;


/**
 * 设置密码
 */

public class CustomerCodeView extends RelativeLayout {
    private EditText editText;
    private TextView[] TextViews;
    private StringBuffer stringBuffer = new StringBuffer();
    private int count = 6;
    // 这里的6是因为我的验证码是6位的（小伙伴根据验证码位数自己改）
    private String inputContent;
    public CustomerCodeView(Context context) {
        this(context, null);
    }
    public CustomerCodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public CustomerCodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TextViews = new TextView[6];
        View.inflate(context, R.layout.setthepassword, this);
        editText = (EditText) findViewById(R.id.et);
        TextViews[0] = (TextView) findViewById(R.id.item_iv1);
        TextViews[1] = (TextView) findViewById(R.id.item_iv2);
        TextViews[2] = (TextView) findViewById(R.id.item_iv3);
        TextViews[3] = (TextView) findViewById(R.id.item_iv4);
        TextViews[4] = (TextView) findViewById(R.id.item_iv5);
        TextViews[5] = (TextView) findViewById(R.id.item_iv6);
        editText.setCursorVisible(false);//将光标隐藏
        setListener();
    }
    private void setListener() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                //如果字符不为""时才进行操作
                if (!editable.toString().equals("")) {
                    if (stringBuffer.length() > 5) {
                        //当文本长度大于5位时editText置空,(这里的5根据小伙伴的验证码位数xiugai)
                        editText.setText("");
                        return;
                    } else {
                        //将文字添加到StringBuffer中
                        stringBuffer.append(editable);
                        editText.setText("");//添加后将EditText置空
                        count = stringBuffer.length();
                        inputContent = stringBuffer.toString();
                        if (stringBuffer.length() == 6) {

                            //这里的6是因为我的验证码是6位的（小伙伴根据验证码位数自己改）
//文字长度位6 则调用完成输入的监听
                            if (inputCompleteListener != null) {
                                inputCompleteListener.inputComplete();
                            }
                        }
                    }
                    for (int i = 0; i < stringBuffer.length(); i++) {
                        TextViews[i].setText(String.valueOf(inputContent.charAt(i)));
                        TextViews[i].setBackgroundResource(R.mipmap.rect_ok);
                    }
                }
            }
        });
        editText.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL
                        && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (onKeyDelete()) return true;
                    return true;
                }
                return false;
            }
        });
    }
    public boolean onKeyDelete() {
        if (count == 0) {
            count = 6; // 这里的6是因为我的验证码是6位的（小伙伴根据验证码位数自己改）
            return true;
        }
        if (stringBuffer.length() > 0) {
            //删除相应位置的字符
            stringBuffer.delete((count - 1), count);
            count--;
            inputContent = stringBuffer.toString();
            TextViews[stringBuffer.length()].setText("");
            TextViews[stringBuffer.length()].setBackgroundResource(R.mipmap.rect_no);
            if (inputCompleteListener != null)
                inputCompleteListener.deleteContent(true);//有删除就通知manger
        }
        return false;
    }
    /**     * 清空输入内容     */
    public void clearEditText() {
        stringBuffer.delete(0, stringBuffer.length());
        inputContent = stringBuffer.toString();
        for (int i = 0; i < TextViews.length; i++) {
            TextViews[i].setText("");
            TextViews[i].setBackgroundResource(R.mipmap.rect_no);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
    private InputCompleteListener inputCompleteListener;
    public void setInputCompleteListener(InputCompleteListener inputCompleteListener) {
        this.inputCompleteListener = inputCompleteListener;
    }
    public interface InputCompleteListener {
        void inputComplete();
        void deleteContent(boolean isDelete);
    }
    /**     * 获取输入文本     *     * @return     */
    public String getEditContent() {
        return inputContent;
    }
}