package com.lianghuawang.cottonfarmer.activity.my;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.ApplyForALoanActivity;
import com.lianghuawang.cottonfarmer.activity.personalinformation.RepaymentActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//我的贷款
public class LoanActivity extends BaseActivity implements View.OnClickListener {

    private GridView grid;
    private Button loan_apply_btn;
    private Button loan_money_btn;
    private ImageView loan_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_loan;
    }

    @Override
    protected void initView() {
        loan_return = (ImageView)findViewById(R.id.loan_return);
        loan_apply_btn = (Button) findViewById(R.id.loan_apply_btn);
        loan_money_btn = (Button) findViewById(R.id.loan_money_btn);
        grid = (GridView) findViewById(R.id.grid);
        List<String> integers = new ArrayList<>();
        String[] s={"","","","",""};

        ArrayAdapter<List<Integer>> adapter = new ArrayAdapter(LoanActivity.this, R.layout.iamge, R.id.tv,s);
        grid.setAdapter(adapter);
        loan_return.setOnClickListener(this);
        loan_money_btn.setOnClickListener(this);
        loan_apply_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loan_return:
                finish();
                break;
                //去还钱
            case R.id.loan_money_btn:
                startActivity(new Intent(LoanActivity.this,RepaymentActivity.class));
                break;
            //申请贷款
            case R.id.loan_apply_btn:
                startActivity(new Intent(LoanActivity.this,ApplyForALoanActivity.class));
                break;
        }
    }
}
