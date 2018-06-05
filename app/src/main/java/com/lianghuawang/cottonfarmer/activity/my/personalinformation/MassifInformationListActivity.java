package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.MassifInformationListAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 地块信息列表
 */

public class MassifInformationListActivity extends BaseActivity implements View.OnClickListener {


    private ImageView massifinformation_return;
    private RecyclerView massifinformation_recy;
    private LinearLayout massifinformation_xinzeng;
    List<Bean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_massif_information_list;
    }

    @Override
    protected void initView() {
        massifinformation_return = (ImageView) findViewById(R.id.massifinformation_return);
        massifinformation_return.setOnClickListener(this);

        massifinformation_recy = (RecyclerView) findViewById(R.id.massifinformation_recy);
        massifinformation_recy.setLayoutManager(new LinearLayoutManager(this));
        Bean bean = new Bean();
        bean.setName("地块俗称：");
        list.add(bean);
        MassifInformationListAdapter massifInformationListAdapter = new MassifInformationListAdapter(list);
        massifinformation_recy.setAdapter(massifInformationListAdapter);


        massifinformation_xinzeng = (LinearLayout) findViewById(R.id.massifinformation_xinzeng);
        massifinformation_xinzeng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.massifinformation_return:
                finish();
                break;
            //新增地块信息
            case R.id.massifinformation_xinzeng:
                startActivity(new Intent(MassifInformationListActivity.this, NewPlotInformationActivity.class));
                break;
        }
    }
}
