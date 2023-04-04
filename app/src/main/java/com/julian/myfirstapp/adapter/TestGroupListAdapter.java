package com.julian.myfirstapp.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.julian.myfirstapp.R;
import com.julian.myfirstapp.bean.GroupDataBean;
import com.julian.myfirstapp.bean.TestItemBean;

import java.util.List;

import androidx.annotation.Nullable;

public class TestGroupListAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public TestGroupListAdapter(@Nullable List<MultiItemEntity> data) {
        super(data);
        addItemType(0,R.layout.item_father);
        addItemType(1,R.layout.item_rv_test);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        int pos = helper.getAdapterPosition();
        if (item.getItemType()==0){
            //组标题
            GroupDataBean item0 = (GroupDataBean) item;
            helper.setText(R.id.tv_father,item0.getTitle());
            helper.getView(R.id.tv_father).setOnClickListener(v -> {
                item0.setExpend(!item0.isExpanded());
                if (item0.isExpend()) {
                    expand(pos, false);
                } else {
                    collapse(pos, false);
                }
            });

        }else if (item.getItemType()==1) {
            //子条目
            TestItemBean item1 = (TestItemBean) item;
            helper.addOnClickListener(R.id.iv);
            helper.setText(R.id.title, item1.getTitle())
                    .setText(R.id.subTitle, item1.getSubTitle())
                    .setText(R.id.date, item1.getDate());

            ImageView imageView = helper.getView(R.id.iv);
            Glide.with(mContext).load(item1.getPicUrl())
                    //.transform(new CenterCrop(),new RoundedCorners(30))
                    //.apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                    .into(imageView);

        }

    }
}
