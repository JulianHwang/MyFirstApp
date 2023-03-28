package com.julian.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.julian.myfirstapp.fragment.MainFragment;
import com.julian.myfirstapp.fragment.MyFragment;
import com.julian.myfirstapp.fragment.NewsFragment;
import com.julian.myfirstapp.fragment.NoticeFragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    RadioGroup rg;
    MainFragment mainFragment;
    NewsFragment secondFragment;
    Fragment mCurrFragment;
    private NoticeFragment noticeFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /* TextView tv1 = findViewById(R.id.tv1);
       tv1.setText("你好！");

        Log.d("TAG","Main-onCreate--");

        findViewById(R.id.btn).setOnClickListener(v -> {
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("data",tv1.getText().toString());
            intent.putExtra("data2",123);
            startActivity(intent);
        });*/


        initView();
        initEvent();
        selectPage(0);



    }

    private void initView() {
         frameLayout = findViewById(R.id.frameLayout);
         rg = findViewById(R.id.rg);
    }

    private void initEvent(){
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectPage(rg.indexOfChild(rg.findViewById(checkedId)));
            }
        });
    }


    private void changeFragment(Fragment showFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (!showFragment.isAdded()) {
            ft.add(R.id.frameLayout, showFragment);
        }
        // mCurrFragment 存储当前显示的 Fragment
        if (mCurrFragment != null) {
            ft.hide(mCurrFragment);
        }
        ft.show(showFragment);
        mCurrFragment = showFragment;

        ft.commit();
    }

    private void selectPage(int index){
        switch (index){
            case 0:
                if (mainFragment==null){
                    mainFragment = new MainFragment();
                }
                changeFragment(mainFragment);
                break;
            case 1:
                if (secondFragment==null){
                    secondFragment = new NewsFragment();
                }
                changeFragment(secondFragment);
                break;
            case 2:
                if (noticeFragment==null){
                    noticeFragment = new NoticeFragment();
                }
                changeFragment(noticeFragment);
                break;
            case 3:
                if (myFragment==null){
                    myFragment = new MyFragment();
                }
                changeFragment(myFragment);
                break;
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG","Main-onRestart--");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","Main-onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","Main-onResume--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","Main-onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","Main-onStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","Main-onDestroy--");

    }
}