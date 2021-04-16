package com.exa.durararala;

public class PlanetsItem {
    private int imgId;
    private String content;

    public PlanetsItem(int imgId, String content){
        this.imgId=imgId;
        this.content=content;
    }

    public int getImgId(){
        return imgId;

    }
    public  String getContent(){
        return content;
    }
}
