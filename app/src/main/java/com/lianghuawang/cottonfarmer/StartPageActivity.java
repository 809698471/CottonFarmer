package com.lianghuawang.cottonfarmer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * 启动页
 */

public class StartPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_start_page);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(StartPageActivity.this, AdvertisingPageActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }).start();

    }
}



