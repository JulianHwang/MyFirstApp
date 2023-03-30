package com.julian.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.julian.myfirstapp.adapter.TestAdapter;
import com.julian.myfirstapp.bean.TestItemBean;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        BarUtils.transparentStatusBar(this);
        View statusBarView = findViewById(R.id.statusBarView);
        statusBarView.getLayoutParams().height = BarUtils.getStatusBarHeight();
        findViewById(R.id.iv_back).setOnClickListener(v -> {finish();});
        ((TextView)findViewById(R.id.tv_title)).setText("村红特产");

        String pic1="https://img1.baidu.com/it/u=307074048,654359288&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500";
        String pic2="https://lmg.jj20.com/up/allimg/1114/062621110J7/210626110J7-10-1200.jpg";
        String pic3="https://lmg.jj20.com/up/allimg/4k/s/02/210924233115O14-0-lp.jpg";


        ArrayList<TestItemBean> list = new ArrayList<>();
        list.add(new TestItemBean(pic1,"title1","subTitle1","2023-03-30"));
        list.add(new TestItemBean(pic2,"title2","subTitle2","2023-04-30"));
        list.add(new TestItemBean(pic3,"title3","subTitle3","2023-05-30"));
        list.add(new TestItemBean(pic1,"title4","subTitle4","2023-06-30"));
        list.add(new TestItemBean(pic2,"title5","subTitle5","2023-07-30"));
         rv = (RecyclerView) findViewById(R.id.rv);
        TestAdapter testAdapter = new TestAdapter(list);
        rv.setAdapter(testAdapter);
    }
}