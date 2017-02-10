package com.gura.step02notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //자동 취소 알림 버튼
        Button makeNotiBtn=(Button)
                findViewById(R.id.makeNotiBtn);
        makeNotiBtn.setOnClickListener(this);
        //수동 취소 알림 버튼
        Button makeNotiBtn2=(Button)
                findViewById(R.id.makeNotiBtn2);
        makeNotiBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.makeNotiBtn:
                makeNoti(true);
                break;
            case R.id.makeNotiBtn2:
                makeNoti(false);
                break;
        }
    }

    //알림 띄우기
    public void makeNoti(boolean isAutoCancel){
        // 알림을 클릭했을때 시작시킬 Activity 정보를 가지고 있는 Intent
        // 객체 생성
        Intent intent=new Intent(this, NotiActivity.class);
        //새로운 Task 에서 액티비티를 실행할수 있도록 플레그 설정
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // NotiActivity 에 전달할 데이터가 있다면 intent 객체에 담는다.
        intent.putExtra("msg","Intent 객체에 전달한 데이터 입니다.");
        //인텐트 전달자 객체에 인텐트 객체를 담는다.
        PendingIntent pIntent=
                PendingIntent.getActivity(this, 0, intent, 0);
        //Notification 객체를 생성한다. (알림객체를만들고)
        Notification noti=new NotificationCompat.Builder(this)
                .setContentIntent(pIntent)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("나야!")
                .setContentText("저녁에 한잔 하까?")
                .setTicker("간단 메세지")
                .setDefaults(Notification.DEFAULT_SOUND |
                        Notification.DEFAULT_VIBRATE)//알림소리
                .setAutoCancel(isAutoCancel)//알림상단 클릭하면 자동으로 사라짐
                .build();
        //알림 메니져 객체의 참조값을 얻어와서
        NotificationManager notiManager=(NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        //알림을 띄운다.  (알림객체를뛰울라면 매니져 객체를 얻어와야됨)
        notiManager.notify(AppConstants.NOTI_ID, noti);//999는 알림의 아이디임 상수 값으로 관리하면 좋음
                                      //알림의 아이디를 알면 수동으로 지울수잇음
    }
}
