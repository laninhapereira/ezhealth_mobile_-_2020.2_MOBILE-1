package com.example.ezhealth_mobile.entity;

public class Example_Item_Alimento {
    private int mImageResource;
    private String textAlimento;
    private String textMassa;
    private String textCalorias;


    public Example_Item_Alimento(String text1, String text2, String text3){
        //mImageResource = imageResource;
        textAlimento = text1;
        textMassa = text2;
        textCalorias = text3;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getTextAlimento() {
        return textAlimento;
    }

    public String getTextMassa() {
        return textMassa;
    }

    public String getTextCalorias(){
        return textCalorias;
    }
}
