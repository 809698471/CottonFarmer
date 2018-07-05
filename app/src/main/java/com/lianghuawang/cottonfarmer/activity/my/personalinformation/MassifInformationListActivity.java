package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.MassifInformationListAdapter;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.DelDikuai;
import com.lianghuawang.cottonfarmer.entity.my.DiKuaiList;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 地块信息列表
 */

public class MassifInformationListActivity extends BaseActivity implements View.OnClickListener, MassifInformationListAdapter.OnItemDelListener {

    @Bind(R.id.massifinformation_recy)
    RecyclerView mRecycler;


    private ImageView massifinformation_return;
    private LinearLayout massifinformation_xinzeng;
    private MassifInformationListAdapter adapter;
    private ArrayList<String> code;
    private String token;
    private int type;
    private List<DiKuaiList.DataBean> dataBeans;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_massif_information_list;
    }

    @Override
    protected void initView() {
        massifinformation_return = (ImageView) findViewById(R.id.massifinformation_return);
        massifinformation_return.setOnClickListener(this);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MassifInformationListAdapter(mRecycler, dataBeans);
        mRecycler.setAdapter(adapter);
        adapter.setListener(this);

        massifinformation_xinzeng = (LinearLayout) findViewById(R.id.massifinformation_xinzeng);
        massifinformation_xinzeng.setOnClickListener(this);

        Intent intent = getIntent();
        type = intent.getIntExtra("type", 1);
        token = intent.getStringExtra("token");
        code = intent.getStringArrayListExtra("code");
        showLoadingDialog(this);
        getApi();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getApi();
    }

    private void getApi() {
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("division", code.get(0));
        params.put("group", code.get(1));
        params.put("even", code.get(2));
        params.put("area_type", type + "");
        params.put("township", code.get(3));
        params.put("village", code.get(4));
        LogUtils.d(params.toString());
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, token, Concat.BLOCK_URL, params, new GsonObjectCallback<DiKuaiList>() {
            @Override
            public void onUi(DiKuaiList diKuaiList) {
                if (diKuaiList.isSuccess()) {
                    dismissdingDialog();
                    adapter.getData(diKuaiList.getData());
                } else {
                    dismissdingDialog();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                dismissdingDialog();
                ToastUtils.showLong(MassifInformationListActivity.this, ConstantUtil.NETERROR);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.massifinformation_return:
                finish();
                break;
            //新增地块信息
            case R.id.massifinformation_xinzeng:
                Intent intent = new Intent(MassifInformationListActivity.this, NewPlotInformationActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("token", token);
                intent.putStringArrayListExtra("code", code);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void delItem(int position, int id) {
        Map<String, String> params = new HashMap<>();
        params.put("plant_id", id+"");
        OkHttp3Utils.doPost(ConstantUtil.tokenKey, token, Concat.DELETEMASSIFINFORMATION_URL, params, new GsonObjectCallback<DelDikuai>() {
            @Override
            public void onUi(DelDikuai delDikuai) {
                if (delDikuai.isSuccess()){
                    getApi();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
