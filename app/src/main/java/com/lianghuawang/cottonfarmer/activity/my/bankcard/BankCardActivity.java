package com.lianghuawang.cottonfarmer.activity.my.bankcard;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.mycredit.BankCardBindingActivity;
import com.lianghuawang.cottonfarmer.adapter.base.BankCardAdapter;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.CardList;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

//我的银行卡
public class BankCardActivity extends BaseActivity {
    @Bind(R.id.bankcard_return)
    ImageView bankcard_return;

    @Bind(R.id.commit)
    ImageView commit;

    @Bind(R.id.lv_item)
    RecyclerView mRecyclerView;

    private String Token;
    private LinearLayoutManager manager;
    private BankCardAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card;
    }

    @Override
    protected void initView() {
        Token = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP)
                .getString(ConstantUtil.LOGINTOKEN,"");
        initRecylcView();
        showLoadingDialog(this);
        getData();
    }

    private void initRecylcView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayout.VERTICAL,true);
        mRecyclerView.setLayoutManager(manager);
        adapter = new BankCardAdapter(mRecyclerView,null);
        mRecyclerView.setAdapter(adapter);
    }

    @OnClick({R.id.bankcard_return,R.id.commit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commit:
                Intent intent = new Intent(BankCardActivity.this, BankCardBindingActivity.class);
                intent.putExtra(ConstantUtil.INTENTTOKEN,Token);
                startActivity(intent);
                break;
            case R.id.bankcard_return:
                finish();
                break;
        }
    }

    public void getData() {
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, Concat.BANKCARDLIST_URL, new GsonObjectCallback<CardList>() {
            @Override
            public void onUi(CardList cardList) {
                adapter.getBankList(cardList.getData());
                dismissdingDialog();
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
