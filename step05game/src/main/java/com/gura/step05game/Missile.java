package com.gura.step05game;

/**
 * Created by user on 2017-02-13.
 */

public class Missile {
    //12(미사일). 미사일 클래스 정의
    private int x;//x좌표
    private int y;//y좌표
    private boolean isDead;//배열에서 제거할지 여부(배열에 미사일 쌓이기 때문에
                           // 위에 화면을 벋어낫을때 적기랑 만났을때 )


    public Missile(){}

    public Missile(int x, int y, boolean isDead) {
        this.x = x;
        this.y = y;
        this.isDead = isDead;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
