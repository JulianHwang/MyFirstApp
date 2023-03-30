package com.julian.myfirstapp.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.julian.myfirstapp.R;
import com.julian.myfirstapp.bean.HomeItemBean;
import com.julian.myfirstapp.bean.TestItemBean;

import java.util.List;

import androidx.annotation.Nullable;

public class TestAdapter extends BaseQuickAdapter<TestItemBean, BaseViewHolder> {

    public TestAdapter(@Nullable List<TestItemBean> data) {
        super(R.layout.item_rv_test, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestItemBean item) {
        helper.setText(R.id.title,item.getTitle())
        .setText(R.id.subTitle,item.getSubTitle())
        .setText(R.id.date,item.getDate());

        ImageView imageView = helper.getView(R.id.iv);
        Glide.with(mContext).load(item.getPicUrl())
                //.transform(new CenterCrop(),new RoundedCorners(30))
                //.apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(imageView);


    }
}
