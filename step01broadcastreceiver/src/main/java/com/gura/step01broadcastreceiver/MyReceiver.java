package com.gura.step01broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
    [ 방송 수신자 객체 ]

    - BroodcastReceiver 추상 클래스를 상속 받아서 만든다.
    - onReceive() 메소드 오버라이딩 한다.
    - 안드로이드 4대 컴포넌트중에0 하나 이기 때문에 AndroidManifest.xml
      문서에 등록이 되어야 한다.

 */
public class MyReceiver extends BroadcastReceiver {

    //방송이 수신되면 호출되는 메소드
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "MERONG 방송이 수신 되었네?",
                              Toast.LENGTH_SHORT).show();

    }


}
