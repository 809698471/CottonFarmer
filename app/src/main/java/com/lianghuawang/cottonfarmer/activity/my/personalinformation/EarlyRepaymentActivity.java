package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.EarlyRepaymentAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//提前还款
public class EarlyRepaymentActivity extends BaseActivity {

    private RecyclerView earlyrepayment_recy;
List<Bean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_early_repayment;
    }

    @Override
    protected void initView() {
        earlyrepayment_recy = (RecyclerView) findViewById(R.id.earlyrepayment_recy);
        earlyrepayment_recy.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("未还本金：");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花灾害险");
//        list.add(bean);
        //设置Adapter
        EarlyRepaymentAdapter adapter = new EarlyRepaymentAdapter( list);
        earlyrepayment_recy.setAdapter(adapter);
    }
}
