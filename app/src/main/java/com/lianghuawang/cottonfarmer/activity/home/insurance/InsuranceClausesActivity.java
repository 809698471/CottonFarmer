package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.news.HeadLineActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import butterknife.Bind;
import butterknife.OnClick;

//保险条款
public class InsuranceClausesActivity extends BaseActivity {

    @Bind(R.id.iv_insuranceclauses_return)
    ImageView mReturn;
    @Bind(R.id.wv_insurance_clauses_content)
    WebView mWebView;

    private ImageView insuranceclauses_return;

    private String mInsurance_act;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_clauses;
    }

    @Override
    protected void initView() {

        mInsurance_act = getIntent().getStringExtra(ConstantUtil.INSURANCE_ACT);
//        WebSettings webSettings = mWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        mWebView.setWebViewClient(new HeadLineActivity.MyWebViewClient());
        mWebView.loadDataWithBaseURL(null,mInsurance_act,"text/html", "UTF-8",null);
    }

    @OnClick(R.id.iv_insuranceclauses_return)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_insuranceclauses_return:
                finish();
                break;
        }
    }
}
