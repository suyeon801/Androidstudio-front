package com.example.myrecylerview;

public class SingerItem {

    //멤버변수 설정
    String name;
    String mobile;

    //Generate -> Constructor
    public SingerItem(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    //Generate -> Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
