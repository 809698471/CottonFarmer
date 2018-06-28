package com.lianghuawang.cottonfarmer.activity.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.bankcard.BankCardActivity;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.PersonalInformationActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.PerfectAPI;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.Perfect_Receive_Information;
import com.lianghuawang.cottonfarmer.tools.MessageEvent;
import com.lianghuawang.cottonfarmer.tools.view.CircleImageView;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;

import static com.lianghuawang.cottonfarmer.config.Concat.APIS;

/**
 * 我的
 */
public class MyFragment extends Fragment implements View.OnClickListener {

    private final static int CODE = 1;
    private final static int RECODE = 4;

    private LinearLayout myfragment_bankcard;
    private LinearLayout myfragment_thebooks;
    private LinearLayout myfragment_order;
    private LinearLayout myfragment_insurance;
    private LinearLayout myfragment_compensation;
    private LinearLayout myfragment_credit;
    private LinearLayout myfragment_loan;
    private ImageView myfragment_setup;
    private ImageView myfragment_personalinformation;
    private TextView mUsername;
    private Perfect_Receive_Information.DataBean mData;

    private SharedPreferencesUtil Per;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.myfragment, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Per = SharedPreferencesUtil.newInstance(ConstantUtil.PERSONAL);
        PerfectAPI api = PerfectAPI.newInstance();
        api.getToken()
                .requestGet(new GsonObjectCallback<Perfect_Receive_Information>() {
                    @Override
                    public void onUi(Perfect_Receive_Information data) {
                        if (data.isSuccess()) {
                            LogUtils.d("请求成功"+data.getData().getUsername());
                            setData(data.getData());
                            Per.putString(ConstantUtil.PERSONAL_HEAD,Concat.IMAGE_URL + "/" + data.getData().getAvatar());
                            mData = data.getData();
                        } else {
//                            ToastUtils.showLong(getContext(),data.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        ToastUtils.showLong(getContext(), "网络连接失败");
                    }
                })
                .over();
    }

    private void setData(Perfect_Receive_Information.DataBean data){
        Glide.with(getContext())
                .load(Concat.IMAGE_URL + "/" + data.getAvatar())
                .error(R.mipmap.button)
                .into(myfragment_personalinformation);
        if (data.getUsername() != null) {
            mUsername.setText(data.getUsername());
        }
    }


    private void initView(View view) {
        myfragment_personalinformation = (CircleImageView) view.findViewById(R.id.myfragment_personalinformation);
        myfragment_bankcard = (LinearLayout) view.findViewById(R.id.myfragment_bankcard);
        myfragment_thebooks = (LinearLayout) view.findViewById(R.id.myfragment_thebooks);
        myfragment_order = (LinearLayout) view.findViewById(R.id.myfragment_order);
        myfragment_insurance = (LinearLayout) view.findViewById(R.id.myfragment_insurance);
        myfragment_compensation = (LinearLayout) view.findViewById(R.id.myfragment_compensation);
        myfragment_credit = (LinearLayout) view.findViewById(R.id.myfragment_credit);
        myfragment_loan = (LinearLayout) view.findViewById(R.id.myfragment_loan);
        myfragment_setup = (ImageView) view.findViewById(R.id.myfragment_setup);
        mUsername = view.findViewById(R.id.tv_username);
        myfragment_personalinformation.setOnClickListener(this);
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
            //个人信息
            case R.id.myfragment_personalinformation:
                LoginUtils.StartActivity(getActivity(),PersonalInformationActivity.class,CODE,RECODE);
                break;
            //我的银行卡
            case R.id.myfragment_bankcard:
                LoginUtils.StartActivity(getActivity(),BankCardActivity.class,CODE,RECODE);
                break;
            //我的账本
            case R.id.myfragment_thebooks:
                LoginUtils.StartActivity(getActivity(),TheBooksActivity.class,CODE,RECODE);
                break;
            //我的订单
            case R.id.myfragment_order:
                EventBus.getDefault().register(getActivity());
                EventBus.getDefault().post(new MessageEvent(true));
                EventBus.getDefault().unregister(getActivity());
                break;
            //我的保险
            case R.id.myfragment_insurance:
                LoginUtils.StartActivity(getActivity(),InsuranceActivity.class,CODE,RECODE);
                break;
            //报案理赔
            case R.id.myfragment_compensation:
                LoginUtils.StartActivity(getActivity(),ClaimCompensationActivity.class,CODE,RECODE);
                break;
            //我的信用
            case R.id.myfragment_credit:
                LoginUtils.StartActivity(getActivity(),MyCreditActivity.class,CODE,RECODE);
                break;
            //我的贷款
            case R.id.myfragment_loan:
                LoginUtils.StartActivity(getActivity(),LoanActivity.class,CODE,RECODE);
                break;
            //我的设置
            case R.id.myfragment_setup:
                LoginUtils.StartActivity(getActivity(),SetUpActivity.class,CODE,RECODE);
                break;
        }
    }

    public void onResumeData() {
        initData();
    }
}
