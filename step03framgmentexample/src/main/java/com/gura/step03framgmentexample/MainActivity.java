package com.gura.step03framgmentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gura.step03framgmentexample.fragments.ConsoleFragment;
import com.gura.step03framgmentexample.fragments.InputFragment;

public class MainActivity extends AppCompatActivity
        implements InputFragment.InputFramgentListener,
        View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button goNextBtn=(Button)findViewById(R.id.goNextBtn);
        goNextBtn.setOnClickListener(this);
    }


    @Override
    public void sendMessage(String msg) {
        //인자로 전달된 문자열을 ConsoleFragment 객체에 전달한다.
        FragmentManager fragmentManager=getSupportFragmentManager();
        ConsoleFragment cfragment=(ConsoleFragment)
                fragmentManager.findFragmentById(R.id.consoleFragment);
        cfragment.printMessage(msg);
    }

    @Override
    public void onClick(View v) {
        //액티비티 이동
        Intent intent=new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}
