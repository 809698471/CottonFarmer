package com.lianghuawang.cottonfarmer.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//我的贷款
public class LoanActivity extends BaseActivity implements View.OnClickListener {

    private GridView grid;
    private Button loan_apply_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_loan;
    }

    @Override
    protected void initView() {
        loan_apply_btn = (Button) findViewById(R.id.loan_apply_btn);
        grid = (GridView) findViewById(R.id.grid);
        List<String> integers = new ArrayList<>();
        String[] s={"","","","",""};

        ArrayAdapter<List<Integer>> adapter = new ArrayAdapter(LoanActivity.this, R.layout.iamge, R.id.tv,s);
        grid.setAdapter(adapter);

        loan_apply_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //申请贷款
            case R.id.loan_apply_btn:
                startActivity(new Intent(LoanActivity.this,ApplyForALoanActivity.class));
                break;
        }
    }
}
