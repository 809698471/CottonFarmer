package com.lianghuawang.cottonfarmer.activity.my;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.Find_tab_Adapter;
import com.lianghuawang.cottonfarmer.fragment.myinsurance.AppointmentFragment;
import com.lianghuawang.cottonfarmer.fragment.myinsurance.ExpiredFragment;
import com.lianghuawang.cottonfarmer.fragment.myinsurance.GuaranteeFragment;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//我的保险
public class InsuranceActivity extends BaseActivity implements View.OnClickListener {

    private TabLayout tab_insurance_title;
    private ViewPager vp_insurance_pager;
    private AppointmentFragment appointmentFragment;
    private GuaranteeFragment guaranteeFragment;
    private ExpiredFragment expiredFragment;
    private List<Fragment> list_fragment;
    private List<String> list_title;
    private Find_tab_Adapter find_tab_adapter;
    private ImageView insurance_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance;
    }

    @Override
    protected void initView() {
        insurance_return = (ImageView) findViewById(R.id.insurance_return);
        insurance_return.setOnClickListener(this);
        tab_insurance_title = (TabLayout) findViewById(R.id.tab_insurance_title);
        vp_insurance_pager = (ViewPager) findViewById(R.id.vp_insurance_pager);

        //初始化各fragment
        appointmentFragment = new AppointmentFragment();
        guaranteeFragment = new GuaranteeFragment();
        expiredFragment = new ExpiredFragment();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(appointmentFragment);
        list_fragment.add(guaranteeFragment);
        list_fragment.add(expiredFragment);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("预约中");
        list_title.add("保障中");
        list_title.add("已过期");


        //设置TabLayout的模式
        tab_insurance_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_insurance_title.addTab(tab_insurance_title.newTab().setText(list_title.get(0)));
        tab_insurance_title.addTab(tab_insurance_title.newTab().setText(list_title.get(1)));
        tab_insurance_title.addTab(tab_insurance_title.newTab().setText(list_title.get(2)));

        find_tab_adapter = new Find_tab_Adapter(getSupportFragmentManager(), list_fragment, list_title);
        vp_insurance_pager.setAdapter(find_tab_adapter);
        tab_insurance_title.setupWithViewPager(vp_insurance_pager);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
