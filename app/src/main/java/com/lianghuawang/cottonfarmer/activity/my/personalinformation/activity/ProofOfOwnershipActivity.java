package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.BuildConfig;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.PersonalInformationActivity;
import com.lianghuawang.cottonfarmer.tools.view.FileUtil;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.io.File;

//权属证明
public class ProofOfOwnershipActivity extends BaseActivity implements View.OnClickListener {
    //请求访问外部存储
    private static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 103;
    //请求写入外部存储
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 104;

    //请求相机
    private static final int REQUEST_CAPTURE = 100;

    private ImageView proofofownership_return;
    private Button proofofownership_next;

    //调用照相机返回图片文件
    private File tempFile;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_proof_of_ownership;
    }

    @Override
    protected void initView() {
        proofofownership_return = (ImageView) findViewById(R.id.proofofownership_return);
        proofofownership_next = (Button) findViewById(R.id.proofofownership_next);
        proofofownership_return.setOnClickListener(this);
        proofofownership_next.setOnClickListener(this);
    }

    /**
     * 上传头像
     */
    private void uploadHeadImage() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow, null);
        TextView btnCarema = (TextView) view.findViewById(R.id.btn_camera);
        TextView btnPhoto = (TextView) view.findViewById(R.id.btn_photo);
        TextView btnCancel = (TextView) view.findViewById(R.id.btn_cancel);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        popupWindow.setOutsideTouchable(true);
        View parent = LayoutInflater.from(this).inflate(R.layout.activity_personal_information, null);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        //popupWindow在弹窗的时候背景半透明
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.5f;
        getWindow().setAttributes(params);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0f;
                getWindow().setAttributes(params);
            }
        });

        btnCarema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //权限判断
                if (ContextCompat.checkSelfPermission(ProofOfOwnershipActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(ProofOfOwnershipActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                } else {
                    //跳转到调用系统相机
                    gotoCamera();
                }
                popupWindow.dismiss();
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //权限判断
                if (ContextCompat.checkSelfPermission(ProofOfOwnershipActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请READ_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(ProofOfOwnershipActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            READ_EXTERNAL_STORAGE_REQUEST_CODE);
                    Log.e("------------", "00000000000000000");
                } else {
                    Log.e("------------", "11111111111111");
                    //跳转到相册
//                    gotoPhoto();
                }
                popupWindow.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 跳转到照相机
     */
    private void gotoCamera() {
        Log.d("evan", "*****************打开相机********************");
        //创建拍照存储的图片文件
        tempFile = new File(FileUtil.checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/image/"), System.currentTimeMillis() + ".jpg");

        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //设置7.0中共享文件，分享路径定义在xml/file_paths.xml
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(ProofOfOwnershipActivity.this, BuildConfig.APPLICATION_ID + ".fileProvider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, REQUEST_CAPTURE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.proofofownership_return:
                finish();
                break;
            //下一步---购买保险记录
            case R.id.proofofownership_next:
//                startActivity(new Intent(ProofOfOwnershipActivity.this,InsurancePurchaseRecordActivity.class ));
                uploadHeadImage();
                break;
        }

    }
}
