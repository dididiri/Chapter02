package com.gura.step04example;

import java.io.Serializable;


public class CountryDto implements Serializable{
    private int imageResId;
    private String name;
    private String detail;
    //디폴트 생성자
    public CountryDto(){}

    public CountryDto(int imageResId, String name, String detail) {
        this.imageResId = imageResId;
        this.name = name;
        this.detail = detail;
    }

    public int getImageResId() {

        return imageResId;
    }

    public void setImageResId(int imageResId) {

        this.imageResId = imageResId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDetail() {

        return detail;
    }

    public void setDetail(String detail) {

        this.detail = detail;
    }
}
