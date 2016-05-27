package com.example.safeyapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by 似水流年 on 2016/5/18.
 */
public abstract class BaseSetupActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        // 初始化数据
        initData();
        // 初始化事件
        initEvent();


    }

    protected  void initEvent(){

    }
      // 有的界面不需要 就不是abstract
    protected  void initData(){

    }

    protected abstract void initView();

    // 抽取的按钮点击事件
    public void next(View view) {
        nextActivity();

        nextAnimation();
    }


    //抽取的按钮点击事件
    public void prev(View view) {
        prevActivity();
        nextAnimation();
    }








    // 转场动画 用的系统提供的动画
    public void nextAnimation() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void start(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();
    }
    protected abstract void prevActivity();
    protected abstract void nextActivity();}


