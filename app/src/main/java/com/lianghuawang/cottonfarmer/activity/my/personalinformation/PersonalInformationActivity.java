package com.lianghuawang.cottonfarmer.activity.my.personalinformation;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.BuildConfig;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.EssentialInformationActivity;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.InsurancePurchaseRecordActivity;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.PlantingInformationActivity;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.ProofOfOwnershipActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.tools.view.CircleImageView;
import com.lianghuawang.cottonfarmer.tools.view.ClipImageActivity;
import com.lianghuawang.cottonfarmer.tools.view.FileUtil;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.File;
import java.util.HashMap;

import static com.lianghuawang.cottonfarmer.tools.view.FileUtil.getRealFilePathFromUri;

//个人信息
public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {
    //请求相机
    private static final int REQUEST_CAPTURE = 100;
    //请求相册
    private static final int REQUEST_PICK = 101;
    //请求截图
    private static final int REQUEST_CROP_PHOTO = 102;
    //请求访问外部存储
    private static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 103;
    //请求写入外部存储
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 104;
    //调用照相机返回图片文件
    private File tempFile;
    // 1: qq, 2: weixin
    private int type;

    private CircleImageView personalinformation_personalimage;
    private LinearLayout personalinformation_essentialinformation;
    private LinearLayout personalinformation_plantinginformation;
    private LinearLayout personalinformation_proofofownership;
    private LinearLayout personalinformation_insurancepurchaserecord;
    private ImageView personalinformation_return;
    private String token;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_information;
    }

    @Override
    protected void initView() {
        personalinformation_return = (ImageView) findViewById(R.id.personalinformation_return);
        //个人头像
        personalinformation_personalimage = findViewById(R.id.personalinformation_personalimage);

        //基本信息
        personalinformation_essentialinformation = (LinearLayout) findViewById(R.id.personalinformation_essentialinformation);
        //种植信息
        personalinformation_plantinginformation = (LinearLayout) findViewById(R.id.personalinformation_plantinginformation);
        //权属证明
        personalinformation_proofofownership = (LinearLayout) findViewById(R.id.personalinformation_proofofownership);
        //保险购买记录
        personalinformation_insurancepurchaserecord = (LinearLayout) findViewById(R.id.personalinformation_insurancepurchaserecord);
        personalinformation_return.setOnClickListener(this);
        personalinformation_personalimage.setOnClickListener(this);
        personalinformation_essentialinformation.setOnClickListener(this);
        personalinformation_plantinginformation.setOnClickListener(this);
        personalinformation_proofofownership.setOnClickListener(this);
        personalinformation_insurancepurchaserecord.setOnClickListener(this);

        SharedPreferencesUtil sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        token = sp.getString(ConstantUtil.LOGINTOKEN, "as");
        Log.d("tag", "initView: " + token);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personalinformation_return:
                finish();
                break;
            //个人头像
            case R.id.personalinformation_personalimage:
                type = 1;
                uploadHeadImage();
                break;
            //基本信息
            case R.id.personalinformation_essentialinformation:
                startActivity(new Intent(PersonalInformationActivity.this, EssentialInformationActivity.class));
                break;
            //种植信息
            case R.id.personalinformation_plantinginformation:
                startActivity(new Intent(PersonalInformationActivity.this, PlantingInformationActivity.class));

                break;
            //权属证明
            case R.id.personalinformation_proofofownership:
                startActivity(new Intent(PersonalInformationActivity.this, ProofOfOwnershipActivity.class));

                break;
            //保险购买记录
            case R.id.personalinformation_insurancepurchaserecord:
                startActivity(new Intent(PersonalInformationActivity.this, InsurancePurchaseRecordActivity.class));

                break;
        }
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
                if (ContextCompat.checkSelfPermission(PersonalInformationActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(PersonalInformationActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
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
                if (ContextCompat.checkSelfPermission(PersonalInformationActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请READ_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(PersonalInformationActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            READ_EXTERNAL_STORAGE_REQUEST_CODE);
                    Log.e("------------", "00000000000000000");
                } else {
                    Log.e("------------", "11111111111111");
                    //跳转到相册
                    gotoPhoto();
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
     * 外部存储权限申请返回
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                gotoCamera();
            }
        } else if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                gotoPhoto();
            }
        }
    }

    /**
     * 跳转到相册
     */
    private void gotoPhoto() {
        Log.d("evan", "*****************打开图库********************");
        //跳转到调用系统图库
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "请选择图片"), REQUEST_PICK);
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
            Uri contentUri = FileProvider.getUriForFile(PersonalInformationActivity.this, BuildConfig.APPLICATION_ID + ".fileProvider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, REQUEST_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case REQUEST_CAPTURE: //调用系统相机返回
                if (resultCode == RESULT_OK) {
                    gotoClipActivity(Uri.fromFile(tempFile));
                }
                break;
            case REQUEST_PICK:  //调用系统相册返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    gotoClipActivity(uri);
                }
                break;
            case REQUEST_CROP_PHOTO:  //剪切图片返回
                if (resultCode == RESULT_OK) {
                    final Uri uri = intent.getData();
                    if (uri == null) {
                        return;
                    }
                    String cropImagePath = getRealFilePathFromUri(getApplicationContext(), uri);
                    Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);
                    if (type == 1) {
//
                        personalinformation_personalimage.setImageBitmap(bitMap);
                        SubmitImg();
                    } else {

                    }
                    //此处后面可以将bitMap转为二进制上传后台网络
                    //......

                }
                break;
        }
    }


    /**
     * 打开截图界面
     */
    public void gotoClipActivity(Uri uri) {
        if (uri == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, ClipImageActivity.class);
        intent.putExtra("type", type);
        intent.setData(uri);
        startActivityForResult(intent, REQUEST_CROP_PHOTO);
    }

    public void SubmitImg() {
        HashMap<String, Object> map = new HashMap<>();

        map.put("image", tempFile);

        OkHttp3Utils.sendImage(token, Concat.UPLOADAHEADIMAGE_URL, map);
    }

}
