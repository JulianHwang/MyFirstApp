package com.julian.myfirstapp.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class GroupDataBean extends AbstractExpandableItem<TestItemBean> implements MultiItemEntity {

    private  String title;
    private List<TestItemBean> subList;
    private boolean isExpend=true;

    public boolean isExpend() {
        return isExpend;
    }

    public void setExpend(boolean expend) {
        isExpend = expend;
    }

    public GroupDataBean(String title, List<TestItemBean> subList) {
        this.title = title;
        this.subList = subList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TestItemBean> getSubList() {
        return subList;
    }

    public void setSubList(List<TestItemBean> subList) {
        this.subList = subList;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return 0;
    }

}
