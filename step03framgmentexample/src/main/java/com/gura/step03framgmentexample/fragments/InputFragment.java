package com.gura.step03framgmentexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gura.step03framgmentexample.R;

/*
     [ 프레그먼트 클래스 만들기 ]

     - support 페키지에 있는 Fragment 클래스를 상속 받는다.
     - onCreateView() 메소드를 오버라이딩한다.
 */

public class InputFragment extends Fragment implements View.OnClickListener{
    EditText inputMsg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_input, container);
        // View 객체에서 버튼의 참조값을 얻어온다.
        Button sendBtn=(Button)view.findViewById(R.id.sendBtn);
        // 리스너 등록하기
        sendBtn.setOnClickListener(this);
        // EditText 객체의 참조값 얻어오기
        inputMsg=(EditText)view.findViewById(R.id.inputMsg);
        return view;
    }

    @Override
    public void onClick(View v) {
        //입력한 문자열을 읽어온다.
        String msg=inputMsg.getText().toString();
        //액티비티에 전달한다. Activity 참조값을 가져온다 부모타입으로 리턴
        InputFramgentListener listener=
                (InputFramgentListener)getActivity();
        listener.sendMessage(msg);

    }

    public interface InputFramgentListener{
        public void sendMessage(String msg);
    }
}
