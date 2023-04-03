package com.julian.myfirstapp.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class HomeItemBean implements MultiItemEntity {
    private String picUrl;
    private String title;

    public HomeItemBean(String picUrl, String title) {
        this.picUrl = picUrl;
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
