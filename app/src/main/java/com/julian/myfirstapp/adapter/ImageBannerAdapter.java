package com.julian.myfirstapp.adapter;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.julian.myfirstapp.R;
import com.julian.myfirstapp.bean.BannerBean;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * 自定义布局，网络图片
 */
public class ImageBannerAdapter extends BannerAdapter<BannerBean, ImageBannerAdapter.ImageHolder> {
    private Context context;

    public ImageBannerAdapter(Context context, List<BannerBean> mDatas) {
        super(mDatas);
        this.context = context;
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) BannerUtils.getView(parent, R.layout.banner_image);
        //通过裁剪实现圆角
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BannerUtils.setBannerRound(imageView, 6f);
        }
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, BannerBean data, int position, int size) {
        //通过图片加载器实现圆角，你也可以自己使用圆角的imageview，实现圆角的方法很多，自己尝试哈
        Glide.with(context)
                .load(data.getUrl())
 //             .transform(new RoundedCornersTransformation(context, SizeUtils.dp2px(6f), 1))
                .centerCrop()
                .thumbnail(Glide.with(context).load(R.mipmap.ic_default_big))
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.imageView);
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ImageHolder(@NonNull View view) {
            super(view);
            this.imageView = (ImageView) view;
        }
    }
}
