package com.julian.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        BarUtils.transparentStatusBar(this);
        View statusBarView = findViewById(R.id.statusBarView);
        statusBarView.getLayoutParams().height = BarUtils.getStatusBarHeight();
        findViewById(R.id.iv_back).setOnClickListener(v -> {finish();});
        ((TextView)findViewById(R.id.tv_title)).setText("村红特产");
    }
}