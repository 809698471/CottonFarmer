package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.AddDiKuai;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 新增地块信息
 */

public class NewPlotInformationActivity extends BaseActivity {

    @Bind(R.id.et_dihao)
    EditText mDihao;
    @Bind(R.id.et_sucheng)
    EditText mSucheng;
    @Bind(R.id.et_jingdu)
    EditText mJingdu;
    @Bind(R.id.et_weidu)
    EditText mWeidu;
    @Bind(R.id.btn_submit)
    Button mSubmit;

    private ImageView newplotinformation_return;


    private ArrayList<String> code;
    private String token;
    private int type;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_plot_information;
    }

    @Override
    protected void initView() {
        newplotinformation_return = (ImageView) findViewById(R.id.newplotinformation_return);
        newplotinformation_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        type = intent.getIntExtra("type",1);
        token = intent.getStringExtra("token");
        code = intent.getStringArrayListExtra("code");
    }

    @OnClick(R.id.btn_submit)
    public void onClick(Button button){
        showLoadingDialog(this);
        String Dihao = mDihao.getText().toString().trim();
        String Sucheng = mSucheng.getText().toString().trim();
        String Jingdu = mJingdu.getText().toString().trim();
        String Weidu = mWeidu.getText().toString().trim();
        Map<String,String> params = new HashMap<>();
        params.put("area_type",type+"");
        params.put("division",code.get(0));
        params.put("group",code.get(1));
        params.put("even",code.get(2));
        params.put("township",code.get(3));
        params.put("village",code.get(4));
        params.put("vulgo",Sucheng);
        params.put("land_num",Dihao);
        params.put("longitude",Jingdu);
        params.put("latitude",Weidu);
        LogUtils.d("NewPlotInformationActivity:"+params.toString());
        OkHttp3Utils.doPost(ConstantUtil.tokenKey, token, Concat.ADD_BLOCK_URL, params, new GsonObjectCallback<AddDiKuai>() {
            @Override
            public void onUi(AddDiKuai addDiKuai) {
                if (addDiKuai.isSuccess()){
                    dismissdingDialog();
                    ToastUtils.showLong(NewPlotInformationActivity.this,"新增地块成功");
                    NewPlotInformationActivity.this.finish();
                } else {
                    ToastUtils.showLong(NewPlotInformationActivity.this,"新增地块失败");
                    dismissdingDialog();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                ToastUtils.showLong(NewPlotInformationActivity.this,"新增地块失败");
                dismissdingDialog();
            }
        });
    }
}
