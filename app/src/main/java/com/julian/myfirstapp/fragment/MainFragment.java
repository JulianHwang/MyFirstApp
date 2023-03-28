package com.julian.myfirstapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.julian.myfirstapp.R;
import com.julian.myfirstapp.TestActivity;
import com.julian.myfirstapp.adapter.ImageBannerAdapter;
import com.julian.myfirstapp.adapter.MainFragmentAdapter;
import com.julian.myfirstapp.bean.BannerBean;
import com.julian.myfirstapp.bean.HomeItemBean;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment {
    private LinearLayout lly_a;
    private LinearLayout lly_b;
    private LinearLayout lly_c;
    private LinearLayout lly_d;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BarUtils.transparentStatusBar(getActivity());
        initView(view);
        initEvent();

    }

    private void initEvent() {
        lly_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"a被点了",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), TestActivity.class);
                startActivity(intent);
            }
        });
        lly_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"b被点了",Toast.LENGTH_SHORT).show();
            }
        });
        lly_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"c被点了",Toast.LENGTH_SHORT).show();
            }
        });
        lly_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"d被点了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        String pic1="https://img2.baidu.com/it/u=3202947311,1179654885&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500";
        String pic2="https://img1.baidu.com/it/u=413643897,2296924942&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500";
        String pic3="http://pic1.win4000.com/wallpaper/2018-06-27/5b3345789ca2c.jpg";

        lly_a = view.findViewById(R.id.lly_a);
        lly_b = (LinearLayout)view.findViewById(R.id.lly_b);
        lly_c = (LinearLayout)view.findViewById(R.id.lly_c);
        lly_d = (LinearLayout)view.findViewById(R.id.lly_d);
        rv = (RecyclerView)view.findViewById(R.id.rv);
        ArrayList<HomeItemBean> list = new ArrayList<>();
        list.add(new HomeItemBean(pic1,"title1"));
        list.add(new HomeItemBean(pic2,"title2"));
        list.add(new HomeItemBean(pic3,"title3"));
        list.add(new HomeItemBean(pic1,"title4"));
        MainFragmentAdapter adapter = new MainFragmentAdapter(list);
        rv.setAdapter(adapter);

        ArrayList<BannerBean> bannerBeanList = new ArrayList<>();
        bannerBeanList.add(new BannerBean("1","aaa",pic1));
        bannerBeanList.add(new BannerBean("2","bbb",pic2));
        bannerBeanList.add(new BannerBean("3","ccc",pic3));

        Banner banner = view.findViewById(R.id.banner);
        ImageBannerAdapter bannerAdapter = new ImageBannerAdapter(getContext(),bannerBeanList);
        banner.setAdapter(bannerAdapter);
        banner.setIndicator(new RectangleIndicator(getContext()),true);
        banner.setIndicatorRadius(SizeUtils.dp2px(5));
        banner.isAutoLoop(true);
        banner.addBannerLifecycleObserver(this);
        //添加画廊效果
        //banner.setBannerGalleryEffect(30, 10);
        banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
        banner.setIndicatorNormalColorRes(R.color.gray_b9b9b9);
        banner.setIndicatorSelectedColorRes(R.color.gray_707384);
        banner.setIndicatorHeight(SizeUtils.dp2px(6));
        banner.setIndicatorNormalWidth(SizeUtils.dp2px(6));
        banner.setIndicatorSelectedWidth(SizeUtils.dp2px(15));
        banner.setIndicatorSpace(SizeUtils.dp2px(6));
        banner.setIndicatorMargins(new IndicatorConfig.Margins(0,0,SizeUtils.dp2px(15),SizeUtils.dp2px(12)));
        banner.start();

    }
}
