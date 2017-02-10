package com.gura.step05customview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class YourView extends View{
    //색상의 상태를 관리할 맴버필드
    private int colorState=0;
    //생성자1.
    public YourView(Context context) {
        super(context);
    }
    //생성자2.
    public YourView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(colorState==0){
            canvas.drawColor(Color.YELLOW);
        }else if(colorState==1){
            canvas.drawColor(Color.GREEN);
        }else if(colorState==2){
            canvas.drawColor(Color.BLUE);
        }else if(colorState==3){
            canvas.drawColor(Color.RED);
        }
    }
    // 터치 이벤트를 처리 하고 싶으면 onTouchEvent() 메소드를 재정의한다.
    // 좌표가 있다
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        colorState++;
        if(colorState==4){ // 없는 상태일때는
            colorState=0; // 으로 만든다.
        }
        //View 갱신하기 (onDraw() 메소드가 다시 호출된다.
        invalidate();

        return false;
    }
}
