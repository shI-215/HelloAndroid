package com.tcom.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//AppCompatActivity——向下兼容，最低兼容到Android2.1（AppCompatActivity是Activity的子类）
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//通过setContentView引入activity_main布局
    }
}
