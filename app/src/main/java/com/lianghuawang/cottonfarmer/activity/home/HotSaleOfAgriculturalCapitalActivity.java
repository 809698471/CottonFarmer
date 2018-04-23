package com.lianghuawang.cottonfarmer.activity.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.HotSaleOfAgriculturalCapitalAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//热销农资---专题名称
public class HotSaleOfAgriculturalCapitalActivity extends BaseActivity {

    private RecyclerView hotsaleofagriculturalcapital_recy;
    private ImageView hotsaleofagriculturalcapital_return;
    List<Bean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot_sale_of_agricultural_capital;
    }

    @Override
    protected void initView() {
        hotsaleofagriculturalcapital_return = (ImageView) findViewById(R.id.hotsaleofagriculturalcapital_return);
        hotsaleofagriculturalcapital_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        hotsaleofagriculturalcapital_recy = (RecyclerView) findViewById(R.id.hotsaleofagriculturalcapital_recy);
        hotsaleofagriculturalcapital_recy.setLayoutManager(new GridLayoutManager(HotSaleOfAgriculturalCapitalActivity.this, 2));
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("价格：");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花灾害险");
//        list.add(bean);
        //设置Adapter
        HotSaleOfAgriculturalCapitalAdapter adapter = new HotSaleOfAgriculturalCapitalAdapter(list);
        hotsaleofagriculturalcapital_recy.setAdapter(adapter);
    }
}
