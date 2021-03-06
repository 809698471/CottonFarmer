package com.lianghuawang.cottonfarmer.activity.home.news;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.home.news.HeadLine;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.io.IOException;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * creat 2018/06/29 范文轲
 * <p>
 * 链花头条详情页面
 * bug：在OPPO上乱码(已解决)。
 */
public class HeadLineActivity extends BaseActivity {

    @Bind(R.id.wv_new_headline_content)
    WebView mWebView;
    @Bind(R.id.tv_headline_title)
    TextView mNewsTitle;
    @Bind(R.id.iv_headline_back)
    ImageView mBack;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_head_line;
    }

    @Override
    protected void initView() {
        int item = getIntent().getIntExtra(ConstantUtil.HEAD_LINE, 0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        initData(item);
    }

    private void initData(int item) {
        String url = String.format(Concat.NEWS_PARTICULAR, item);
        OkHttp3Utils.doGet(url, new GsonObjectCallback<HeadLine>() {
            @Override
            public void onUi(HeadLine headLine) {
                if (headLine.isSuccess()) {
                    mNewsTitle.setText(headLine.getData().getTitle());
                    String content = headLine.getData().getContent();
                    mWebView.loadDataWithBaseURL(null,content, "text/html", "UTF-8",null);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


        /**
         * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
         **/
        private void imgReset() {
            mWebView.loadUrl("javascript:(function(){" +
                    "var objs = document.getElementsByTagName('img'); " +
                    "for(var i=0;i<objs.length;i++)  " +
                    "{"
                    + "var img = objs[i];   " +
                    "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                    "}" +
                    "})()");
        }
    }

    @OnClick(R.id.iv_headline_back)
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.iv_headline_back:
                HeadLineActivity.this.finish();
                break;
        }
    }
}
