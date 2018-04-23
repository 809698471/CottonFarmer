package com.lianghuawang.cottonfarmer.activity.personalinformation;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.StagingDetailAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//分期明细
public class StagingDetailActivity extends BaseActivity {

    List<Bean> list = new ArrayList<>();
    private RecyclerView stagingdetail_recy;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_staging_detail;
    }

    @Override
    protected void initView() {
        stagingdetail_recy = (RecyclerView) findViewById(R.id.stagingdetail_recy);
        stagingdetail_recy.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("月份：");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花灾害险");
//        list.add(bean);
        //设置Adapter
        StagingDetailAdapter adapter = new StagingDetailAdapter( list);
        stagingdetail_recy.setAdapter(adapter);
    }
}
