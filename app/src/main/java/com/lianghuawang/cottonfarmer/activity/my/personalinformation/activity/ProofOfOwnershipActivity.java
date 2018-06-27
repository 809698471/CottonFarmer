package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
import com.lianghuawang.cottonfarmer.adapter.ProofAdapter;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.Proof;
import com.lianghuawang.cottonfarmer.imageSelect.ImageSelectorUtils;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.ProofAPI;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.ProofInstance;
import com.lianghuawang.cottonfarmer.tools.view.FileUtil;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.PermissionUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.lianghuawang.cottonfarmer.config.Concat.APIS;

//权属证明
public class ProofOfOwnershipActivity extends BaseActivity implements PermissionUtil.Calls, ProofAdapter.AddLinstener, ProofAdapter.DelLinstener {

    @Bind(R.id.proofofownership_return)
    ImageView mBack;

    @Bind(R.id.proofofownership_next)
    Button mSubmit;

    @Bind(R.id.recycler)
    RecyclerView mRecyclerView;

    private PermissionUtil permission;

    //请求访问外部存储
    private static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 103;
    //请求写入外部存储
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 104;

    private static final int REQUEST_CODE = 105;

    //请求相机
    private static final int REQUEST_CAPTURE = 100;

    //调用照相机返回图片文件
    private File tempFile;

    private StaggeredGridLayoutManager layoutManager;

    private ProofAdapter mAdapter;

    private List<ProofInstance.DataBean> mData;

    private String imagePath;

    private String Token;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_proof_of_ownership;
    }

    @Override
    protected void initView() {
        SharedPreferencesUtil sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        Token = sp.getString(ConstantUtil.LOGINTOKEN, "");
        initRecylerView();
        showLoadingDialog(this);
        api();
    }

    private void api() {
        ProofAPI.newInastance()
                .getToken()
                .request(new GsonObjectCallback<ProofInstance>() {
                    @Override
                    public void onUi(ProofInstance proofInstance) {
                        if (proofInstance.getData() != null) {
                            mData = proofInstance.getData();
                            for (ProofInstance.DataBean dataBean : mData) {
                                dataBean.setFlag(-1);
                                dataBean.setImg_url(Concat.IMAGE_URL + dataBean.getImg_url());
                                dataBean.setUpdata(true);
                            }
                            ProofInstance.DataBean dataBean = new ProofInstance.DataBean();
                            dataBean.setFlag(0);
                            dataBean.setUpdata(true);
                            mData.add(0, dataBean);
                        } else {
                            ProofInstance.DataBean dataBean = new ProofInstance.DataBean();
                            dataBean.setFlag(0);
                            dataBean.setUpdata(true);
                            if (mData == null) {
                                mData = new ArrayList<>();
                            }
                            mData.add(dataBean);
                        }
                        mAdapter.getData(mData);
                        dismissdingDialog();
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        dismissdingDialog();
                    }
                });
    }

    private void initRecylerView() {
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ProofAdapter(mRecyclerView, mData);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setAddLinstener(this);
        mAdapter.setDelLinstener(this);
    }


    @OnClick({R.id.proofofownership_return, R.id.proofofownership_next})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.proofofownership_return:
                finish();
                break;
            //下一步---购买保险记录
            case R.id.proofofownership_next:
//                startActivity(new Intent(ProofOfOwnershipActivity.this,InsurancePurchaseRecordActivity.class ));

                UploadImage();
                break;
        }

    }

    /**
     * 添加图片
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
                PermissionUtil(REQUEST_CAPTURE);
                popupWindow.dismiss();
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionUtil(READ_EXTERNAL_STORAGE_REQUEST_CODE);
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
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        permission.Call(requestCode, permissions, grantResults, new PermissionUtil.Call() {
            @Override
            public void succeed() {
                if (requestCode == REQUEST_CAPTURE) {
                    //跳转到调用系统相机
                    gotoCamera();
                } else if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
                    gotoPhoto();
                }
            }

            @Override
            public void error(String permission) {
                return;
            }
        });
    }

    @Override
    public void GoOn(int key) {
        if (key == REQUEST_CAPTURE) {
            //跳转到调用系统相机
            gotoCamera();
        } else if (key == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
            gotoPhoto();
        }
    }

    /**
     * 跳转到照相机
     */
    private void gotoCamera() {
        Log.d("evan", "*****************打开相机********************");
        //创建拍照存储的图片文件
        imagePath = FileUtil.checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/image/") + System.currentTimeMillis() + ".jpg";
        tempFile = new File(imagePath);
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

    private void gotoPhoto() {
        ImageSelectorUtils.openPhoto(this, REQUEST_CODE, false, 9);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAPTURE && resultCode == -1) {//调用系统相机返回
            ProofInstance.DataBean bean = new ProofInstance.DataBean();
            bean.setUpdata(false);
            bean.setImg_url(imagePath);
            bean.setFlag(-1);
            bean.setId(0);
            bean.setIs_real(0);
            mData.add(1, bean);
            mAdapter.getData(mData);
        } else if (requestCode == REQUEST_CODE && data != null) {
            //获取选择器返回的数据
            ArrayList<String> images = data.getStringArrayListExtra(
                    ImageSelectorUtils.SELECT_RESULT);
            for (int i = 0; i < images.size(); i++) {
                ProofInstance.DataBean bean = new ProofInstance.DataBean();
                bean.setUpdata(false);
                bean.setImg_url(images.get(i));
                bean.setFlag(-1);
                bean.setId(0);
                bean.setIs_real(0);
                mData.add(1, bean);
            }
            mAdapter.getData(mData);
        }
    }

    @Override
    public void addImage() {
        uploadHeadImage();
    }

    @Override
    public void delImage(final int position) {
        if (mData.get(position).isUpdata()) {
            Map<String, String> params = new HashMap<>();
            params.put("img_id", mData.get(position).getId() + "");
            OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.DELEPROOFO_URL, params, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    mData.remove(position);
                    Message message = new Message();
                    message.what = 2;
                    handler.sendMessage(message);
                }
            });

        } else {
            mData.remove(position);
            mAdapter.getData(mData);
        }
    }


    private void UploadImage() {
        showLoadingDialog(ProofOfOwnershipActivity.this);
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < mData.size(); i++) {
            if (!mData.get(i).isUpdata()) {
                String[] paths = mData.get(i).getImg_url().split("/");
                String path = paths[paths.length - 1];
                String imagePath = FileUtil.checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/") + path;
                File file1 = new File(imagePath);
                Bitmap bitmap = BitmapFactory.decodeFile(mData.get(i).getImg_url());
                qualityCompress(bitmap, file1);
                File file = new File(imagePath);
                map.put("images["+ i +"]", file);
            }
        }

        OkHttp3Utils.sendImage(Token, Concat.PROOFOFOWNERSHIP_URL, map, new GsonObjectCallback<ProofInstance>() {
            @Override
            public void onUi(ProofInstance proofInstance) {
                if (proofInstance.getData() != null) {
                    mData = proofInstance.getData();
                    for (ProofInstance.DataBean dataBean : mData) {
                        dataBean.setFlag(-1);
                        dataBean.setImg_url(Concat.IMAGE_URL + dataBean.getImg_url());
                        dataBean.setUpdata(true);
                    }
                    ProofInstance.DataBean dataBean = new ProofInstance.DataBean();
                    dataBean.setFlag(0);
                    dataBean.setUpdata(true);
                    mData.add(0, dataBean);
                } else {
                    ProofInstance.DataBean dataBean = new ProofInstance.DataBean();
                    dataBean.setFlag(0);
                    dataBean.setUpdata(true);
                    if (mData == null) {
                        mData = new ArrayList<>();
                    }
                    mData.add(dataBean);
                }
                mAdapter.getData(mData);
                dismissdingDialog();
                ToastUtils.showLong(ProofOfOwnershipActivity.this, "上传成功");
            }

            @Override
            public void onFailed(Call call, IOException e) {
                dismissdingDialog();
                ToastUtils.showLong(ProofOfOwnershipActivity.this, "网络连接不佳，上传失败");
            }
        });
    }

    /**
     * 3.质量压缩
     * 设置bitmap options属性，降低图片的质量，像素不会减少
     * 第一个参数为需要压缩的bitmap图片对象，第二个参数为压缩后图片保存的位置
     * 设置options 属性0-100，来实现压缩
     *
     * @param bmp
     * @param file
     */
    public static void qualityCompress(Bitmap bmp, File file) {
        // 0-100 100为不压缩
        int quality = 20;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        bmp.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 2) {
                mAdapter.getData(mData);
            }
        }
    };
}
