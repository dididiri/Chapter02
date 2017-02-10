package com.gura.step03fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*
     [ Frament ]

     Frament 객체 Activity 관리하에있는 미니 컨트롤러 하위컨트롤러
     Frament 이용하면 코드에 재활용성이 높아짐
     Frament 는 자기만에 View를 갖고잇다
     대신 코딩양이 늘어남
     Frament 는 서로 의존 관계를 가지면안됨
     Frament1 -> Frament2로 줄려면 Activity를 끼고 줌
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // activity_main.xml 에 정의된 TextView 의 참조값
        TextView textView=(TextView)findViewById(R.id.textView);
        // activity_main.xml 에 정의된 Fragment 의 참조값이 필요하다면?
        FragmentManager fManager=getSupportFragmentManager();
                  fManager.findFragmentById(R.id.myFragment);

    }

    public static class MyFragment extends Fragment
                                implements View.OnClickListener{

        // 리턴해주는 View 객체가 MyFrament 의 레이아웃이다(UI).
        // View로 리턴하기위해 오버라이딩함
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            //레이아웃 전개자 객체를 view를 만들고 리턴해줘야됨
            //res/layout/fragment_my.xml 문서를 전개해서 View 객체를 만든다.
            View v=inflater.inflate(R.layout.fragment_my,container);

            //Button 의 참조값 얻어오기
            Button btn=(Button)v.findViewById(R.id.btn1);
            btn.setOnClickListener(this);

            //만든 View 객체를 리턴해준다
            return v;
        }
        //getActivity() frament메소드 나를 관리하는 Activity참조값을 얻어오는 메소드
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"btn1 !", Toast.LENGTH_SHORT).show();
        }
    }
}
