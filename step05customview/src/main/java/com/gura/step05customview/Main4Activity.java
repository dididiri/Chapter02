package com.gura.step05customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // GameView 객체로 화면 채우기
        setContentView(new GameView(this));
    }
}
