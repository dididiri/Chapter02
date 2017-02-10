package com.gura.step03framgmentexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gura.step03framgmentexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-02-09.
 */

public class MsgListFragment extends Fragment{
    //필요한 맴버필드 정의하기
    List<String> msgs;
    ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_msglist, container);
        //listView 의 참조값
        ListView listView=(ListView)view.findViewById(R.id.listView);
        msgs=new ArrayList<>();// Model
        adapter= new ArrayAdapter<String>(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        msgs

                );
        // listView 에 아답타 연결하기
        listView.setAdapter(adapter);
        return view;
    }
    // listView 에 메세지를 출력하는 메소드
    public void printMessage(String msg){
        //모델에 데이터 추가
        msgs.add(msg);
        //UI 를 업데이트 하도록 아답타에 알린다.
        adapter.notifyDataSetChanged();
    }
}
