package com.gura.step05customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        // YourView 객체를 생성해서
        YourView yView=new YourView(this);
        // Activity 가 제어하는 화면을 YourView 객체로 채운다.
        setContentView(yView);
    }
}
