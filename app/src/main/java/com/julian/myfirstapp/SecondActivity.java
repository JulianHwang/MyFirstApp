package com.julian.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.icu.text.SelectFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.julian.myfirstapp.utils.GlideEngine;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.io.File;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("TAG","Second-onCreate--");

        TextView tv2 = findViewById(R.id.tv2);
         img = findViewById(R.id.img);
        tv2.setOnClickListener(view -> selectPic());
    }

    private void selectPic() {
        AndPermission.with(this).runtime()
                .permission(Permission.CAMERA,Permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        chooseImg();
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {

                    }
                })
                .start();

    }

    private void chooseImg() {
        PictureSelector.create(this)
                .openGallery(SelectMimeType.ofImage())
                .setMaxSelectNum(1)
                .setImageEngine(GlideEngine.createGlideEngine())
                .forResult(new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(ArrayList<LocalMedia> result) {
                        String path = result.get(0).getPath();
                        Log.d("TAG","select-pic-path="+path);
                        Glide.with(SecondActivity.this)
                                .load(path)
                                .centerCrop()
                                .into(img);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
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