package com.lianghuawang.cottonfarmer.activity.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.BankCardActivity;
import com.lianghuawang.cottonfarmer.activity.ClaimCompensationActivity;
import com.lianghuawang.cottonfarmer.activity.LoanActivity;
import com.lianghuawang.cottonfarmer.activity.MyCreditActivity;
import com.lianghuawang.cottonfarmer.activity.SetUpActivity;
import com.lianghuawang.cottonfarmer.activity.TheBooksActivity;

/**
 * 我的
 */
public class MyFragment extends Fragment implements View.OnClickListener {


    private LinearLayout myfragment_bankcard;
    private LinearLayout myfragment_thebooks;
    private LinearLayout myfragment_order;
    private LinearLayout myfragment_insurance;
    private LinearLayout myfragment_compensation;
    private LinearLayout myfragment_credit;
    private LinearLayout myfragment_loan;
    private LinearLayout myfragment_setup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.myfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        myfragment_bankcard = (LinearLayout) view.findViewById(R.id.myfragment_bankcard);
        myfragment_thebooks = (LinearLayout) view.findViewById(R.id.myfragment_thebooks);
        myfragment_order = (LinearLayout) view.findViewById(R.id.myfragment_order);
        myfragment_insurance = (LinearLayout) view.findViewById(R.id.myfragment_insurance);
        myfragment_compensation = (LinearLayout) view.findViewById(R.id.myfragment_compensation);
        myfragment_credit = (LinearLayout) view.findViewById(R.id.myfragment_credit);
        myfragment_loan = (LinearLayout) view.findViewById(R.id.myfragment_loan);
        myfragment_setup = (LinearLayout) view.findViewById(R.id.myfragment_setup);

        myfragment_bankcard.setOnClickListener(this);
        myfragment_thebooks.setOnClickListener(this);
        myfragment_order.setOnClickListener(this);
        myfragment_insurance.setOnClickListener(this);
        myfragment_compensation.setOnClickListener(this);
        myfragment_credit.setOnClickListener(this);
        myfragment_loan.setOnClickListener(this);
        myfragment_setup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //我的银行卡
            case R.id.myfragment_bankcard:
                startActivity(new Intent(getActivity(), BankCardActivity.class));
                break;
            //我的账本
            case R.id.myfragment_thebooks:
                startActivity(new Intent(getActivity(), TheBooksActivity.class));
                break;
            //我的订单
            case R.id.myfragment_order:

 //  startActivity(new Intent(getActivity(), OrderFragment.class));
                break;
            //我的保险
            case R.id.myfragment_insurance:
                startActivity(new Intent(getActivity(), InsuranceActivity.class));
                break;
            //报案理赔
            case R.id.myfragment_compensation:
                startActivity(new Intent(getActivity(), ClaimCompensationActivity.class));
                break;
            //我的信用
            case R.id.myfragment_credit:
                startActivity(new Intent(getActivity(), MyCreditActivity.class));
                break;
            //我的贷款
            case R.id.myfragment_loan:
                startActivity(new Intent(getActivity(), LoanActivity.class));
                break;
            //我的设置
            case R.id.myfragment_setup:
                startActivity(new Intent(getActivity(), SetUpActivity.class));
                break;

        }
    }
}