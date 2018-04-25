package com.lianghuawang.cottonfarmer.activity.my;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//帮助
public class HelpActivity extends BaseActivity implements View.OnClickListener {


    private ImageView help_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_help;
    }

    @Override
    protected void initView() {
        help_return = (ImageView)findViewById(R.id.help_return);
        help_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
