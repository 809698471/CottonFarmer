package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

/**
 * 新增地块信息
 */

public class NewPlotInformationActivity extends BaseActivity {

    private ImageView newplotinformation_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_plot_information;
    }

    @Override
    protected void initView() {
        newplotinformation_return = (ImageView) findViewById(R.id.newplotinformation_return);
        newplotinformation_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
