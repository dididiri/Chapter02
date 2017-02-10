package com.gura.step03framgmentexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gura.step03framgmentexample.fragments.InputFragment;
import com.gura.step03framgmentexample.fragments.MsgListFragment;

public class SubActivity extends AppCompatActivity implements InputFragment.InputFramgentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void sendMessage(String msg) {
        // 인자로 전달된 문자열을 MsglistFragment 객체에 전달
        FragmentManager fragmentManager=getSupportFragmentManager();
        MsgListFragment mFragment=(MsgListFragment)
                fragmentManager.findFragmentById(R.id.msgListFragment);
        mFragment.printMessage(msg);
    }
}
