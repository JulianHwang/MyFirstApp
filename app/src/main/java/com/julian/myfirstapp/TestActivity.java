package com.julian.myfirstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.julian.myfirstapp.adapter.TestAdapter;
import com.julian.myfirstapp.bean.TestItemBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private RecyclerView rv;
    private SmartRefreshLayout refreshLayout;
    private TestAdapter testAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsHeader(context);
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(context);
            }
        });

        BarUtils.transparentStatusBar(this);
        View statusBarView = findViewById(R.id.statusBarView);
        statusBarView.getLayoutParams().height = BarUtils.getStatusBarHeight();
        findViewById(R.id.iv_back).setOnClickListener(v -> {finish();});
        ((TextView)findViewById(R.id.tv_title)).setText("村红特产");
        TextView tv_right = findViewById(R.id.tv_right);
        tv_right.setText("添加");
        tv_right.setOnClickListener(view -> {
            Intent intent = new Intent(TestActivity.this, SecondActivity.class);
            startActivityForResult(intent,101);
        });

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
         testAdapter = new TestAdapter(list);
        rv.setAdapter(testAdapter);
        testAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort("您点击的位置下标是："+position);
            }
        });
        testAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId()==R.id.iv){
                    ToastUtils.showShort("您点击图片的Item位置下标是："+position);
                }
            }
        });


         refreshLayout = (SmartRefreshLayout)findViewById(R.id.refreshLayout);
         refreshLayout.setOnRefreshListener(new OnRefreshListener() {
             @Override
             public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                 ToastUtils.showShort("正在刷新...");
                 new Handler().postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         refreshLayout.finishRefresh();
                     }
                 },3000);
             }
         });

         refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
             @Override
             public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                 ToastUtils.showShort("正在加载更多...");
                 new Handler().postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         refreshLayout.finishLoadMore();
                     }
                 },3000);
             }
         });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==101){
            if (resultCode== Activity.RESULT_OK){
                if (data!=null){
                    String name = data.getStringExtra("name");
                    String score = data.getStringExtra("score");
                    String pic_path = data.getStringExtra("pic_path");
                    TestItemBean testItemBean = new TestItemBean(pic_path, name, score, "2023-04-22");
                    testAdapter.addData(testItemBean);
                }
            }
        }
    }
}