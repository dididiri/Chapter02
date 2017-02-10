package com.gura.step05customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by user on 2017-02-10.
 */

public class GameView extends View {
    //배경이미지
    Bitmap backImg;
    //View 의 폭과 높이
    int viewWidth, viewHeight;
    //배경이미지1 의 y 좌표
    int back1Y, back2Y;
    //배경이미지 스크롤 속도
    int scrollSpeed;
    //드래곤의 좌표
    int unitX, unitY;
    //드래곤의 크기
    int unitW, unitH;
    //드래곤의 이미지
    Bitmap unitImg;
    //action down 이 일어난곳의 x 좌표
    int lastX;


    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    /*
        onDraw() 메소드가 호출되기 직적에 먼저 호출되면서
        View 가 차지하고 있는 크기가 메소드의 인자로 전달된다.
        혹은 도중에 View 가 차지하는 크기가 바뀌어도 호출된다.

     */

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //안자로 전달된 화면의 폭과 높이를 맴버필드에 저장한다.
        viewWidth=w;
        viewHeight=h;

        //초기화 메소드 호출
        init();
        // 20/ 1000 초 이후에 handler 객체에 빈 메시지 보내기
        handler.sendEmptyMessageDelayed(0, 20);
    }
    //초기화 하는 메소드
    public void init(){
        //스크롤 스피드 지정
        scrollSpeed = viewHeight/100;

        //배경이미지의 초기 좌표 지정
        back1Y=0;
        back2Y=-viewHeight;

        //배경이미지 읽어들이기
        Bitmap backImg= BitmapFactory
                .decodeResource(getResources(),R.drawable.backbg);
        //배경이미지를 View 의 가로세로에 일치하게 스케일링해서
        //맴버필드에 저장한다.
        this.backImg=Bitmap
                .createScaledBitmap(backImg, viewWidth,viewHeight, false);
        //드래곤의 크기지정
        unitW = viewWidth/5; //화면폭의 1/5
        unitH = unitW; //높이는 폭과 같도록
        //드래곤의 초기 좌표
        unitX = viewWidth/2;
        unitY = viewHeight - unitH*2;
        //드래곤 이미지 읽어들이기
        Bitmap unitImg=BitmapFactory
                .decodeResource(getResources(), R.drawable.unit1);
        //드래곤 이미지 스케일링
        this.unitImg=Bitmap
                .createScaledBitmap(unitImg,unitW,unitH, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 배경 이미지 그리기
        // .drowBitmap(이미지, x, y, 효과)
        canvas.drawBitmap(backImg, 0, back1Y, null);
        canvas.drawBitmap(backImg, 0, back2Y, null);
        // 드래곤 이미지 그리기
        canvas.drawBitmap(unitImg, unitX-unitW/2, unitY-unitH/2, null);
        backScroll();
    }
    //배경이미지 스크롤 처리
    public void backScroll(){
        back1Y += scrollSpeed;
        back2Y += scrollSpeed;
        //배경1이 한계점에 다다랐을때
        if(back1Y >= viewHeight){
            back1Y = -viewHeight;
            back2Y = 0;
        }
        //배경2가 한계점에 다다랐을때
        if(back2Y >= viewHeight){
            back2Y = -viewHeight;
            back1Y = 0;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //이벤트가 일어난 곳의 x 좌표 얻어오기
        int eventX=(int)event.getX();
        int eventY=(int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //터치가 시작 되었을때 x 좌표를 맴버필드에 저장
                lastX=eventX;
                break;

            case MotionEvent.ACTION_MOVE:
                //이벤트가 일어난 x 좌표와 터치가 시작된 좌표의 차이를 구한다.
                int delteX=lastX-eventX;
                //드래곤의  x 좌표에 반영한다.
                unitX=unitX-delteX;
                //현재의 x 좌표는 다음번 action move 될때 과거 좌표이다.
                lastX=eventX;
                break;

        }

        return true;
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            invalidate();//화면 갱신하기
            // 20/1000 초 이후에 hander 객체에 빈 메세지 보내기
            handler.sendEmptyMessageDelayed(0, 20);
        }
    };
}
