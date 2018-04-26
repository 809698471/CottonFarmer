package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//身份证验证
public class AuthenticationActivity extends BaseActivity implements View.OnClickListener {
    private TextView add_dialog1, add_dialog2;
    private Button btn_commit;
    private ImageView layout_zheng, layout_fan;
    private static final int XIANGJI_ZHENG = 1;
    private static final int XIANGJI_FAN = 2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_authentication;

    }

    @Override
    protected void initView() {
        add_dialog1 = findViewById(R.id.text_add);
        add_dialog2 = findViewById(R.id.text_add_dialog);
        btn_commit = findViewById(R.id.btn_commit);
        layout_zheng = findViewById(R.id.layout_zheng);
        layout_fan = findViewById(R.id.layout_fan);

        add_dialog1.setOnClickListener(this);
        add_dialog2.setOnClickListener(this);
        btn_commit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_add:

                //                拍照
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {//判断是否有相机应用
                    startActivityForResult(takePictureIntent, XIANGJI_ZHENG);
                }
                add_dialog1.setVisibility(View.GONE);
                break;
            case R.id.text_add_dialog:
                //                拍照
                Intent takePictureIntent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent1.resolveActivity(getPackageManager()) != null) {//判断是否有相机应用
                    startActivityForResult(takePictureIntent1, XIANGJI_FAN);
                }
                add_dialog2.setVisibility(View.GONE);
                break;
            case R.id.btn_commit:
                Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //相机的回调
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case XIANGJI_ZHENG://返回结果
                if (resultCode != Activity.RESULT_OK) return;
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                layout_zheng.setImageBitmap(imageBitmap);//正
                break;
            case XIANGJI_FAN://返回结果
                if (resultCode != Activity.RESULT_OK) return;
                Bundle extras1 = data.getExtras();
                Bitmap imageBitmap1 = (Bitmap) extras1.get("data");
                layout_fan.setImageBitmap(imageBitmap1);//反
                break;
        }
    }

}
