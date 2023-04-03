package com.julian.myfirstapp.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.julian.myfirstapp.R;
import com.julian.myfirstapp.bean.HomeItemBean;
import com.julian.myfirstapp.bean.TestItemBean;

import java.util.List;

import androidx.annotation.Nullable;

public class MainFragmentAdapter2 extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public MainFragmentAdapter2(@Nullable List<MultiItemEntity> data) {
        super(data);
        addItemType(0,R.layout.item_rv_home_fragment);
        addItemType(1,R.layout.item_rv_test);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {

        if (item.getItemType()==0) {
            HomeItemBean item0 = (HomeItemBean) item;
            helper.setText(R.id.tv, item0.getTitle());
            ImageView imageView = helper.getView(R.id.iv);
            Glide.with(mContext).load(item0.getPicUrl())
                    .transform(new CenterCrop(), new RoundedCorners(30))
                    //.apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                    .into(imageView);
        }else if (item.getItemType()==1){
            TestItemBean item1 = (TestItemBean) item;
            helper.addOnClickListener(R.id.iv);
            helper.setText(R.id.title,item1.getTitle())
                    .setText(R.id.subTitle,item1.getSubTitle())
                    .setText(R.id.date,item1.getDate());

            ImageView imageView = helper.getView(R.id.iv);
            Glide.with(mContext).load(item1.getPicUrl())
                    //.transform(new CenterCrop(),new RoundedCorners(30))
                    //.apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                    .into(imageView);
        }


    }
}
