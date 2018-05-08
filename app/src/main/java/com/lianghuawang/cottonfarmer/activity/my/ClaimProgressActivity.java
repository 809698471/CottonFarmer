package com.lianghuawang.cottonfarmer.activity.my;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

public class ClaimProgressActivity extends BaseActivity {

    private ImageView claimprogress_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_claim_progress;
    }

    @Override
    protected void initView() {
        claimprogress_return = (ImageView) findViewById(R.id.claimprogress_return);
        claimprogress_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
