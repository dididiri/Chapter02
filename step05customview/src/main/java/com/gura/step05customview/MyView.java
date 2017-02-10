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
        canvas.drawColor(Color.YELLOW);
    }
}
