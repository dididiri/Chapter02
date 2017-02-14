package com.gura.step05game;

/**
 * Created by user on 2017-02-13.
 */
//2-5
public class Enemy {
    //2-8
    private int imgIndex; //적기 이미지
    private int x, y; //적기 좌표
    private int energy; // 적기 에너지
    private boolean isDead;//적기 제거 경우

    public Enemy(){}

    public Enemy(int imgIndex, int x, int y, int energy, boolean isDead) {
        this.imgIndex = imgIndex;
        this.x = x;
        this.y = y;
        this.energy = energy;
        this.isDead = isDead;
    }

    public int getImgIndex() {
        return imgIndex;
    }

    public void setImgIndex(int imgIndex) {
        this.imgIndex = imgIndex;
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
