package com.gura.step05game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

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
    //8. 유닛의 x 좌표 최대값 ,최소값
    int minUnitX, maxUnitX;

    //13(미사일).missile 관련 필드
    List<Missile> missList=new ArrayList<>();
    Bitmap missImg; //미사일 이미지
    int missW, missH; //미사일의 폭과 높이
    int missSpeed; //미사일의 속도

    ///20 .count 를 셀변 수 미사일 갯수조절
    int count;


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
        //  20/ 1000 초 이후에 handler 객체에 빈 메시지 보내기
        //4-1 handler.sendEmptyMessageDelayed(0, 20); 메세지는 보내는걸 없애고 매소드를 통해 제어함
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

        //9.드래곤의 최소 x 좌표,최대 y좌표(미리 초기화될때 계산해놓는거)
        //minUnitX = unitW/2;
        //maxUnitX = viewWidth-unitW/2;
        //11. 반정도 들어가고싶으면
        minUnitX=0;
        maxUnitX=viewWidth;

        //드래곤 이미지 읽어들이기
        Bitmap unitImg=BitmapFactory
                .decodeResource(getResources(), R.drawable.unit1);
        //드래곤 이미지 스케일링
        this.unitImg=Bitmap
                .createScaledBitmap(unitImg,unitW,unitH, false);

        //15.(미사일)미사일의 폭과 높이 결정하기
        missW = unitW;
        missH = unitH;
        //미사일 이미지 읽어들이고 스케일링하기
        Bitmap missImg= BitmapFactory
                .decodeResource(getResources(), R.drawable.mi1);
        this.missImg= Bitmap.createScaledBitmap(missImg, missW, missH, false);
        //미사일 속도
        missSpeed = viewHeight / 100;

    }



    // 1초당 50번 호출~됨 onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        // 배경 이미지 그리기
        // .drowBitmap(이미지, x, y, 효과)
        canvas.drawBitmap(backImg, 0, back1Y, null);
        canvas.drawBitmap(backImg, 0, back2Y, null);
        //19.미사일 이미지 그리기(반복문 돌면서)
        for(Missile tmp:missList){
            canvas.drawBitmap(missImg, tmp.getX()-missW/2,
                    tmp.getY()-missW/2, null);
        }

        // 드래곤 이미지 그리기
        canvas.drawBitmap(unitImg, unitX-unitW/2, unitY-unitH/2, null);
        //배경이미지 스크롤 처리
        backScroll();
        //17(미사일) 미사일 만들기(canvas 이용해서 미사일을그려야함)
        makeMissile();
        //19.미사일 움지이기
        moveMissile();

        //21. 카운트 증가 시키기
        count++;
    }

    //18. 미사일 움지는 메소드
    public void moveMissile(){
        for(Missile tmp:missList){
            //미사일 현재 y 좌표에서 속도값 만큼 뺀값을 얻어낸다.
            int resultY=tmp.getY()-missSpeed;
            //현재 미사일 객체에 넣어주기
            tmp.setY(resultY);
            //y좌표가 위쪽 화면을 벗어 났을때
            if(resultY < -missH/2){
                //배열에서 제거 될수 있도록 표시한다.
                tmp.setDead(true);
            }
        }
    }

    //16(미사일) 미사일 만드는 메소드
    public void makeMissile(){
        //22.미사일 갯수 조건
        //10의 배수일때만 만들겟다
        if(count%10 !=0){
            return;
        }

        //18(미사일) 미사일 객체 생성하기
        Missile m=new Missile();
        m.setX(unitX);
        m.setY(unitY);
        //배열에 저장
        missList.add(m);

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
                //7. 양싸이드
                //왼쪽으로 벗어나지 않도록
                // 유닛에x 가 유닛폭 반보다 작으면
                if(unitX < minUnitX){
                    unitX = minUnitX;
                }
                //오른쪽으로 벗어나지 않도록
                //10.미리계산된 max,min 넣기
                if(unitX > maxUnitX){
                    unitX = maxUnitX;
                }

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

    //4. 관리하는 메소드 정의
    //게임을 시작하는 메소드
    public void startGame(){
        //게임을 진행하게 할려면 handle에 메세지가 가야됨 4-1 참조
        //핸들러 객체에 메세지를 보내서 게임이 진행되도록 한다.
        handler.sendEmptyMessage(0);

    }
    //게임을 일시 저장하는 메소드
    public void pauseGame(){
        //핸들러에 메세지를 제거해서 게임이 진행되지 않도록 한다.
        handler.removeMessages(0);
    }
}
