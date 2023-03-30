package com.julian.myfirstapp.bean;

public class TestItemBean {

    private String picUrl;
    private String title;
    private String subTitle;
    private String date;

    public TestItemBean(String picUrl, String title, String subTitle, String date) {
        this.picUrl = picUrl;
        this.title = title;
        this.subTitle = subTitle;
        this.date = date;
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
