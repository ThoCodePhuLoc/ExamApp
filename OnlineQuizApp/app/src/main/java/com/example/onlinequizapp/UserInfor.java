package com.example.onlinequizapp;

public class UserInfor {
    private String address, mClass;
    public UserInfor(){}
    public UserInfor(String address, String mClass){
        this.address = address;
        this.mClass = mClass;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }
}
