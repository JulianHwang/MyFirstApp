package com.julian.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.julian.myfirstapp.adapter.TestGroupListAdapter;
import com.julian.myfirstapp.bean.GroupDataBean;
import com.julian.myfirstapp.bean.TestItemBean;

import java.util.ArrayList;
import java.util.List;

public class TestGroupListActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_group_list);
        rv = (RecyclerView)findViewById(R.id.rv);

        initData();
    }

    private void initData() {
        String pic1="https://img1.baidu.com/it/u=307074048,654359288&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500";
        String pic2="https://lmg.jj20.com/up/allimg/1114/062621110J7/210626110J7-10-1200.jpg";
        String pic3="https://lmg.jj20.com/up/allimg/4k/s/02/210924233115O14-0-lp.jpg";

        ArrayList<GroupDataBean> list = new ArrayList<>();

        ArrayList<TestItemBean> subBeanList = new ArrayList<>();
        TestItemBean subListBean1 = new TestItemBean(pic1,"title1","subTitle1","2022-12-15" );
        TestItemBean subListBean2 = new TestItemBean(pic2,"title2","subTitle2","2022-12-15" );
        TestItemBean subListBean3 = new TestItemBean(pic3,"title3","subTitle3","2022-12-15" );
        subBeanList.add(subListBean1);
        subBeanList.add(subListBean2);
        subBeanList.add(subListBean3);

        ArrayList<TestItemBean> subBeanList2 = new ArrayList<>();
        TestItemBean subListBean11 = new TestItemBean(pic3,"title1","subTitle1","2022-12-15" );
        TestItemBean subListBean22 = new TestItemBean(pic2,"title2","subTitle2","2022-12-15" );
        TestItemBean subListBean33 = new TestItemBean(pic1,"title3","subTitle3","2022-12-15" );
        subBeanList2.add(subListBean11);
        subBeanList2.add(subListBean22);
        subBeanList2.add(subListBean33);


        list.add(new GroupDataBean("组一",subBeanList));
        list.add(new GroupDataBean("组二",subBeanList2));

        TestGroupListAdapter adapter = new TestGroupListAdapter(getData(list));
        rv.setAdapter(adapter);
        adapter.expandAll();//注意:这句不加的话子列表不会显示！
    }

    public ArrayList<MultiItemEntity> getData(List<GroupDataBean> resultBeanList) {
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < resultBeanList.size(); i++) {
            GroupDataBean resultBean = resultBeanList.get(i);
            for (int j = 0; j < resultBean.getSubList().size(); j++) {
                resultBean.addSubItem(resultBean.getSubList().get(j));
            }
            res.add(resultBean);
        }
        return res;
    }
}