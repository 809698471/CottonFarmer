package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.BuildConfig;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.Attestation;
import com.lianghuawang.cottonfarmer.entity.my.IDCard;
import com.lianghuawang.cottonfarmer.imageSelect.ImageSelectorUtils;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.tools.view.ClipImageActivity;
import com.lianghuawang.cottonfarmer.tools.view.FileUtil;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.ImageUtil;
import com.lianghuawang.cottonfarmer.utils.PermissionUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.lianghuawang.cottonfarmer.tools.view.FileUtil.getRealFilePathFromUri;
/**
 * create by fanwenke at 2018/7/3
 * 身份证实名认证
 * bug:小米手机拍照，照片逆时针旋转90°
 */
public class AuthenticationActivity extends BaseActivity implements View.OnClickListener, PermissionUtil.Calls {

    private static final String BODY_ZHENG = "id_positive";
    private static final String BODY_FAN = "id_reverse";
    private static final String BODY_SHOU = "hand_img";

    private TextView tv1_paizhao, tv2_xiangce, tv2_no;
    private int TAKE_PHOTO = 1;   //拍照
    private Dialog dialog;
    private int clicked = 0;
    private static final int REQUEST_CAPTURE = 100;
    private static final int REQUEST_CODE = 105;

    @Bind(R.id.text_add)
    TextView text_add_zheng;
    @Bind(R.id.text_add_dialog)
    TextView text_add_fan;
    @Bind(R.id.text_add_people)
    TextView text_add_people;
    @Bind(R.id.btn_commit)
    Button btn_commit;
    @Bind(R.id.layout_zheng)
    ImageView layout_zheng;
    @Bind(R.id.layout_fan)
    ImageView layout_fan;
    @Bind(R.id.layout_people)
    ImageView layout_people;

    private String Token;

    private PermissionUtil permission;
    private String imagePath;
    private File tempFile;
    private static final int REQUEST_CROP_PHOTO = 102;

    private SharedPreferencesUtil mEssentialSP;//基本信息SP

    @Override
    protected int getLayoutId() {
        return R.layout.activity_authentication;
    }

    @Override
    protected void initView() {
        mEssentialSP = SharedPreferencesUtil.newInstance(ConstantUtil.ESSENTIAL_INFORMATION_KEY);
        SharedPreferencesUtil sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        Token = sp.getString(ConstantUtil.LOGINTOKEN, "");
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
        tv1_paizhao.setOnClickListener(AuthenticationActivity.this);
        tv2_xiangce.setOnClickListener(AuthenticationActivity.this);
        tv2_no.setOnClickListener(AuthenticationActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.takePhoto:
                //系统6.0以上需要判断是否有危险权限
                PermissionUtil(REQUEST_CAPTURE);
                break;
            case R.id.choosePhoto:
                PermissionUtil(REQUEST_CODE);
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
        }
    }

    @OnClick(R.id.btn_commit)
    public void OnClick(View view) {
        if (view.getId() == R.id.btn_commit) {
            Attestation();
            showLoadingDialog(this);
        }
    }

    private void PermissionUtil(int key) {
        permission = PermissionUtil.newInstance(this, key);
        permission
                .Build()
                .add(Manifest.permission.READ_EXTERNAL_STORAGE)
                .add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .add(Manifest.permission.CAMERA)
                .setPermission(this)
                .build();
    }

    @Override
    public void GoOn(int key) {
        if (key == REQUEST_CAPTURE) {
            //跳转到调用系统相机
            gotoCamera();
        } else if (key == REQUEST_CODE) {
            gotoPhoto();
        }
    }

    private void gotoCamera() {
        imagePath = FileUtil.checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/image/") + System.currentTimeMillis() + ".jpg";
        tempFile = new File(imagePath);
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //设置7.0中共享文件，分享路径定义在xml/file_paths.xml
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(AuthenticationActivity.this, BuildConfig.APPLICATION_ID + ".fileProvider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, REQUEST_CAPTURE);
    }

    private void gotoPhoto() {
        ImageSelectorUtils.openPhoto(this, REQUEST_CODE, false, 1);
    }

    //接受回传值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {  //回传值接受成功
            if (requestCode == REQUEST_CAPTURE) {
                dialog.dismiss();
            } else if (requestCode == REQUEST_CODE) {     //正面的相册取图
                ArrayList<String> images = data.getStringArrayListExtra(
                        ImageSelectorUtils.SELECT_RESULT);
                imagePath = images.get(0);
                dialog.dismiss();
            } else if (requestCode == REQUEST_CROP_PHOTO) {
                final Uri uri = data.getData();
                if (uri == null) {
                    return;
                }
                String cropImagePath = getRealFilePathFromUri(getApplicationContext(), uri);
                Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);
                tempFile = new File(cropImagePath);
                layout_zheng.setImageBitmap(bitMap);
            }
            showLoadingDialog(AuthenticationActivity.this);
            switch (clicked) {
                case 1:
                    Glide.with(AuthenticationActivity.this)
                            .load(imagePath).into(layout_zheng);
                    text_add_zheng.setVisibility(View.GONE);
                    imageCompression(imagePath);
                    break;
                case 2:
                    Glide.with(AuthenticationActivity.this)
                            .load(imagePath).into(layout_fan);
                    text_add_fan.setVisibility(View.GONE);
                    imageCompression(imagePath);
                    break;
                case 3:
                    Glide.with(AuthenticationActivity.this)
                            .load(imagePath).into(layout_people);
                    text_add_people.setVisibility(View.GONE);
                    imageCompression(imagePath);
                    break;
            }
        }
    }

    /**
     * 压缩图片
     **/
    private void imageCompression(String bitmap) {
        File imageFile = ImageUtil.compressImage(bitmap);
        uploadPictures(imageFile);
    }

    /**
     * 上传图片
     **/
    private void uploadPictures(File imageFile) {
        Map<String, Object> params = new HashMap<>();
        String key = "";
        if (clicked == 1) {
            key = BODY_ZHENG;
        } else if (clicked == 2) {
            key = BODY_FAN;
        } else if (clicked == 3) {
            key = BODY_SHOU;
        }
        params.put(key, imageFile);

        OkHttp3Utils.sendImage(Token, Concat.UPLOADIDENTITYCARDZHENG_URL, params, new GsonObjectCallback<IDCard>() {
            @Override
            public void onUi(IDCard idCard) {
                if (idCard.isSuccess()) {
                    dismissdingDialog();
                } else {
                    dismissdingDialog();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                dismissdingDialog();
            }
        });
    }

    private void Attestation() {
        Map<String, String> params = new HashMap<>();
        OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.IDENTITYCARDREALNAMEAUTHENTICATION_URL,
                params, new GsonObjectCallback<Attestation>() {
                    @Override
                    public void onUi(Attestation attestation) {
                        if (attestation.isSuccess()) {
                            ToastUtils.showLong(AuthenticationActivity.this, attestation.getData().getResult());
                            mEssentialSP.putBoolean(ConstantUtil.ESSENTIAL_AUTHENTICATION,true);
                            dismissdingDialog();
                        } else {
                            ToastUtils.showLong(AuthenticationActivity.this, attestation.getData().getErrmsg());
                            dismissdingDialog();
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        dismissdingDialog();
                    }
                });
    }

}

