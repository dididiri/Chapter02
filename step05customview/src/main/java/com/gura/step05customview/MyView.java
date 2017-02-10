package com.gura.step05customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
/*
   버튼의 부모는 뷰다

 */
public class MyView extends View {
    // 색상의 상태값을 관리할 맴버필드
    private int colorState=0;

    //생성자1
    public MyView(Context context) {
        super(context);
    }
    //생성자2
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    // onDraw() 메소드를 재정의한다.
    @Override
    protected void onDraw(Canvas canvas) {
        // View 를 노란색으로 칠하기

        if(colorState==0){
            canvas.drawColor(Color.YELLOW);
        }else if(colorState==1){
            canvas.drawColor(Color.GREEN);
        }
    }
    public void changeColor(){
        colorState=1;
        // 현재 View 에 표시된 내용을 clear 하고 다시 그리기
        // 결과적으로 onDraw() 메소드가 다시 호출된다.
        invalidate();
    }
}
