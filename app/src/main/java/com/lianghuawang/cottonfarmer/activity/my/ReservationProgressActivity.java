package com.lianghuawang.cottonfarmer.activity.my;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//预约进度
public class ReservationProgressActivity extends BaseActivity {


    private ImageView reservationprogress_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reservation_progress;
    }

    @Override
    protected void initView() {
        reservationprogress_return = (ImageView) findViewById(R.id.reservationprogress_return);
        reservationprogress_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
