package com.gura.step03framgmentexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gura.step03framgmentexample.R;

/**
 * Created by user on 2017-02-09.
 */

public class ConsoleFragment extends Fragment{
    //필요한 맴버필드 정의하기
    EditText console;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //레이아웃 전개자 객체를 view를 만들고 리턴해줘야됨
        //res/layout/fragment_console.xml 문서를 전개해서 View 객체를 만든다.
        View view=inflater.inflate(R.layout.fragment_console,container);
        //EditText 객체의 참조값 얻어오기
        console=(EditText)view.findViewById(R.id.console);
        return view;
    }
    //인자로 전달되는 내용을 EditText 에 추가 하는 메소드
    public void printMessage(String msg){

        console.append(msg+"\r\n");
    }
}
