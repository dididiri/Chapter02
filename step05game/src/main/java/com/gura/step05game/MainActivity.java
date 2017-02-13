package com.gura.step05game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    //5.밑에 onOptionsItemSelected 메소드에 참조값이 필요하니깐 맴버필드로 바꿈
    GameView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //GameView 객체 생성해서 참조값을 변수에 담기
        view=new GameView(this);
        //GameView 객체로 화면을 모두 체울수 있도록(view 타입이나 int R.id 인자로 전달받음)
        setContentView(view);

        /*//32(효과음). SoundPool 객체를 생성하고
        SoundPool soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        //33. 효과음을 로딩 시키고 효과물의 아이디를 얻어낸다.(비동기로딩)
        int soundId = soundPool.load(this, R.raw.laser1,1);
        //34. 재생시키는법 (필요한시점에 로딩은 미리(33) 해놓고 나중에 플레하는거(34)
        soundPool.play(soundId, 1,1,1,0,1);*/

        //37. Util 클래스에 있는 SoundManger(싱글톤)
        Util.SoundManager sManager=Util.SoundManager.getInstance();
        //초기화 하기 (Context type 데이터가 필요하다)
        sManager.init(this);
        //효과음 등록하기
        sManager.addSound(MyConstants.SOUND_FIRE,R.raw.laser1);
        sManager.addSound(MyConstants.SOUND_BOOM,R.raw.shoot1);
        sManager.addSound(MyConstants.SOUND_DIE,R.raw.birddie);

    }
    //1.매뉴를 만들고싶으면 특정메소드를 오버라이딩해야됨
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //2.메뉴 전개자 객체를 이용해서 res/menu/menu_main.xml
        //문서를 전개해서 메뉴를 구성한다.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //3.메뉴를 눌렀을때 동작하고 싶을때 매소드 오버라이딩
    //옵션 메뉴를 선택했을때 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //res 아이디는 16진수 관리된다
            case R.id.menu_start:
                view.startGame();
                break;
            case R.id.menu_pause:
                view.pauseGame();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}





















