package com.lianghuawang.cottonfarmer.activity.home;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//棉花交易
public class CottonTradeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView conttontrade_return;
    private Button conttontrade_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cotton_trade;
    }

    @Override
    protected void initView() {
        conttontrade_return = (ImageView) findViewById(R.id.conttontrade_return);
        conttontrade_btn = (Button) findViewById(R.id.conttontrade_btn);

        conttontrade_return.setOnClickListener(this);
        conttontrade_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.conttontrade_return:
                finish();
                break;
                //查询>>>我的棉花 订单
            case R.id.conttontrade_btn:
                startActivity(new Intent(CottonTradeActivity.this,MyCottonOrderActivity.class));
                break;
        }
    }
}
