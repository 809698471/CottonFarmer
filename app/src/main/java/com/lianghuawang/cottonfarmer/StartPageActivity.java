package com.lianghuawang.cottonfarmer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.lianghuawang.cottonfarmer.mvp.module.login.LoginActivity;

/**
 * 启动页
 */

public class StartPageActivity extends AppCompatActivity {
    boolean isFirstIn = false;
    private Intent intent;
    private SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_start_page);
        final SharedPreferences sharedPreferences = getSharedPreferences("is_first_in_data", Context.MODE_PRIVATE);
        edit =  sharedPreferences.edit();
        isFirstIn = sharedPreferences.getBoolean("isFirstIn",true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstIn) {
                    intent = new Intent(StartPageActivity.this, GuideActivity.class);
                    startActivity(intent);
                    finish();
                    //之前错误没有这两句，没有设置Boolean类型，并提交
                    edit.putBoolean("isFirstIn",false);
                    edit.commit();
                } else {
                    intent = new Intent(StartPageActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    /*    new Thread(new Runnable() {
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
        }).start();*/

    }
}



