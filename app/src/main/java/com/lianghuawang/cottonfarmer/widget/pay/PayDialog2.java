package com.lianghuawang.cottonfarmer.widget.pay;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatSpinner;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;

public class PayDialog2 extends Dialog {

    private ImageView dimss;
    private TextView paypass_content;
    private TextView dingdan;
    private AppCompatSpinner fukuan;
    private Button pay;
    private String cancelable;
    private String name;

    private DimssLienter dimssLienter;
    private PayLienter payLienter;

    public void getDimssLienter(DimssLienter dimssLienter) {
        this.dimssLienter = dimssLienter;
    }

    public void getPayLienter(PayLienter payLienter) {
        this.payLienter = payLienter;
    }

    public PayDialog2(@NonNull Context context, String s) {
        super(context);
    }

    public PayDialog2(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public PayDialog2(@NonNull Context context, String category_name, String cancelable) {
        super(context, R.style.BottomDialogStyle);
        this.cancelable = cancelable;
        this.name = category_name;
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 获取Window的LayoutParams
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        // 一定要重新设置, 才能生效
        window.setAttributes(attributes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_dialog);
        dimss = findViewById(R.id.paypass_close);
        paypass_content = findViewById(R.id.paypass_content);
        dingdan = findViewById(R.id.tv_dingdan);
        fukuan = findViewById(R.id.tv_fukuan);
        pay = findViewById(R.id.btn_pay);

        paypass_content.setText(cancelable);
        dingdan.setText(name);

        dimss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dimssLienter.dimss();
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payLienter.pay(1);
            }
        });
    }

    public interface DimssLienter{
        void dimss();
    }

    public interface PayLienter{
        void pay(int payType);
    }
}
