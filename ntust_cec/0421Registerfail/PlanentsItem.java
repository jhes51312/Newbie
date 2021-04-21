package com.mple.a0421register;

public class PlanentsItem {

    private int mImgId;
    private String mName;
    private String mPhone;
    private String mAge;
    private String mAddress;

    public PlanentsItem(int ImgId, String name , String phone , String age , String address){
        mImgId = ImgId;
        mName = name;
        mPhone = phone;
        mAge = age;
        mAddress = address;
    }

    public int getImgId(){
        return mImgId;
    }
    public String getName(){
        return mName;
    }
    public String getmPhone(){
        return mPhone;
    }
    public String getAge(){
        return mAge;
    }
    public String getAddress(){
        return mAddress;
    }
}
