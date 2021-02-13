package com.example.ezhealth_mobile.entity;

public class ExampleItemAlimento {
    private int mImageResource;
    private String textAlimento;
    private String textMassa;
    private String textCalorias;


    public ExampleItemAlimento(String text1, String text2, String text3){
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
