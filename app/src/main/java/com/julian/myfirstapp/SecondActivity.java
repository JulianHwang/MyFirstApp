package com.julian.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("TAG","Second-onCreate--");
        String data = getIntent().getStringExtra("data");
        int data2 = getIntent().getIntExtra("data2", -1);

        TextView tv2 = findViewById(R.id.tv2);
        tv2.setText(data+data2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","Second-onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","Second-onResume--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","Second-onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","Second-onStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","Second-onDestroy--");

    }
}