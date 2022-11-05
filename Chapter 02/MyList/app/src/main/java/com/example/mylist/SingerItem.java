package com.example.mylist;

public class SingerItem {

    String name;
    String mobile;
    int resID;

    //생성자 생성
    public SingerItem(String name, String mobile, int resID) {
        this.name = name;
        this.mobile = mobile;
        this.resID = resID;
    }

    //변수에 직접 접근하지 말고 getName() setName() 함수를 이용해라
    //generator -> getter and setter
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

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    //generator -> toString()
    @Override
    public String toString() {
        return "SingerItem{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}