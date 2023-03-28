package com.julian.myfirstapp.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.julian.myfirstapp.R;
import com.julian.myfirstapp.bean.HomeItemBean;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.Nullable;

public class MainFragmentAdapter extends BaseQuickAdapter<HomeItemBean, BaseViewHolder> {

    public MainFragmentAdapter(@Nullable List<HomeItemBean> data) {
        super(R.layout.item_rv_home_fragment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItemBean item) {
        helper.setText(R.id.tv,item.getTitle());
        ImageView imageView = helper.getView(R.id.iv);
        Glide.with(mContext).load(item.getPicUrl())
                .transform(new CenterCrop(),new RoundedCorners(30))
                //.apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(imageView);


    }
}
