package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.Manifest;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.io.FileNotFoundException;

//身份证验证
public class AuthenticationActivity extends BaseActivity {
    private TextView text_add_zheng, text_add_fan, text_add_people;
    private TextView tv1_paizhao, tv2_xiangce;
    private TextView tv2_no;
    private Button btn_commit;
    private ImageView layout_zheng, layout_fan, layout_people;
    private int TAKE_PHOTO = 1;   //拍照
    private int GET_PHOTO = 2;    //取照片
    private Dialog dialog;
    private int clicked = 0;
    private int MY_PERMISSIONS_REQUEST_CAMERA = 10012;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_authentication;

    }

    @Override
    protected void initView() {
        text_add_zheng = findViewById(R.id.text_add);
        text_add_fan = findViewById(R.id.text_add_dialog);
        text_add_people = findViewById(R.id.text_add_people);
        btn_commit = findViewById(R.id.btn_commit);
        layout_zheng = findViewById(R.id.layout_zheng);
        layout_fan = findViewById(R.id.layout_fan);
        layout_people = findViewById(R.id.layout_people);
        layout_zheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                clicked = 1;
            }
        });
        layout_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                clicked = 2;
            }
        });
        layout_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                clicked = 3;
            }
        });
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AuthenticationActivity.this, "提交", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showDialog() {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        //初始化控件
        tv1_paizhao = inflate.findViewById(R.id.takePhoto);
        tv2_xiangce = inflate.findViewById(R.id.choosePhoto);
        tv2_no = inflate.findViewById(R.id.btn_cancel);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        if (dialogWindow == null) {
            return;
        }
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
        tv1_paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //系统6.0以上需要判断是否有危险权限
                if (Build.VERSION.SDK_INT >= 23) {
                    //如果权限授权了 打开相机
                    if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(
                            AuthenticationActivity.this, Manifest.permission.CAMERA)) {
                        try {
                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                                startActivityForResult(takePictureIntent, TAKE_PHOTO);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        //如果没有授权了
                        //提示用户开户权限
                        String[] perms = {"android.permission.CAMERA"};
                        ActivityCompat.requestPermissions(AuthenticationActivity.this, perms, MY_PERMISSIONS_REQUEST_CAMERA);
                    }
                } else {
                    //不是6.0以上的系统，直接打开相机
                    try {
                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(takePictureIntent, TAKE_PHOTO);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //设置拍照意图
//                Intent mIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(mIntent, TAKE_PHOTO);
             /*   Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, TAKE_PHOTO);
                }*/
            }
        });
        tv2_xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, GET_PHOTO);
            }
        });
        tv2_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    //接受回传值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {  //回传值接受成功
            Log.e("1111111111111111", requestCode + "-------------------" + resultCode);
            switch (clicked) {
                case 1:
                    if (requestCode == TAKE_PHOTO) {    //正面拍照取图
//                        Bundle bundle = data.getExtras();   //获取data数据集合
//                        Bitmap bitmap = (Bitmap) bundle.get("data");        //获得data数据
//                        Log.e("TAG", "拍照回传bitmap：" + bitmap);
//                        layout_zheng.setImageBitmap(bitmap);
                        Bundle extras = data.getExtras();
                        Bitmap mImageBitmap = (Bitmap) extras.get("data");
                        layout_zheng.setImageBitmap(mImageBitmap);
                        dialog.dismiss();
                        text_add_zheng.setVisibility(View.GONE);
                    } else {
                        if (requestCode == GET_PHOTO) {     //正面的相册取图
                            ContentResolver contentResolver = getContentResolver();
                            try {
                                Bitmap bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(data.getData()));
                                Log.e("TAG", "从相册回传bitmap：" + bitmap);
                                layout_zheng.setImageBitmap(bitmap);

                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            dialog.dismiss();
                        }
                    }
                    text_add_zheng.setVisibility(View.GONE);
                    break;
                case 2:
                    if (requestCode == TAKE_PHOTO) {    //反面的拍照取图
//                        Bundle bundle = data.getExtras();   //获取data数据集合
//                        Bitmap bitmap = (Bitmap) bundle.get("data");        //获得data数据
//                        Log.e("TAG", "拍照回传bitmap：" + bitmap);
//                        layout_fan.setImageBitmap(bitmap);
                        Bundle extras = data.getExtras();
                        Bitmap mImageBitmap = (Bitmap) extras.get("data");
                        layout_fan.setImageBitmap(mImageBitmap);
                        dialog.dismiss();
                        text_add_fan.setVisibility(View.GONE);
                    } else {
                        if (requestCode == GET_PHOTO) {     //反面的相册取图
                            ContentResolver contentResolver = getContentResolver();
                            try {
                                Bitmap bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(data.getData()));
                                Log.e("TAG", "从相册回传bitmap：" + bitmap);
                                layout_fan.setImageBitmap(bitmap);
                                dialog.dismiss();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    text_add_fan.setVisibility(View.GONE);
                    break;
                case 3:
                    if (requestCode == TAKE_PHOTO) {    //手持的拍照取图
//                        Bundle bundle = data.getExtras();   //获取data数据集合
//                        Bitmap bitmap = (Bitmap) bundle.get("data");        //获得data数据
//                        Log.e("TAG", "拍照回传bitmap：" + bitmap);
//                        layout_people.setImageBitmap(bitmap);
                        Bundle extras = data.getExtras();
                        Bitmap mImageBitmap = (Bitmap) extras.get("data");
                        layout_people.setImageBitmap(mImageBitmap);
                        dialog.dismiss();
                        text_add_people.setVisibility(View.GONE);
                    } else {
                        if (requestCode == GET_PHOTO) {     //反面的相册取图
                            ContentResolver contentResolver = getContentResolver();
                            try {
                                Bitmap bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(data.getData()));
                                Log.e("TAG", "从相册回传bitmap：" + bitmap);
                                layout_people.setImageBitmap(bitmap);
                                dialog.dismiss();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    text_add_people.setVisibility(View.GONE);
                    break;
            }

        }
    }
}
