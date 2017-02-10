package com.gura.step05customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //버튼을 눌렀을때 호출되는 메소드
    public void btnClicked(View v){
        //MyView 의 참조값 얻어오기
        MyView myView=(MyView)findViewById(R.id.myView);
        //맴버 메소드 호출하기
        myView.changeColor();
    }
}
