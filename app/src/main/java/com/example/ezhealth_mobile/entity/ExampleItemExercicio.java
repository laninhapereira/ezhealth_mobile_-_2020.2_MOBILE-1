package com.example.ezhealth_mobile.entity;

public class ExampleItemExercicio {
    private int mImageResource;
    private String textExercicio;
    private String textDuracao;
    private String textCalorias;


    public ExampleItemExercicio(String text1, String text2, String text3){
        //mImageResource = imageResource;
        textExercicio = text1;
        textDuracao = text2;
        textCalorias = text3;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getTextExercicio() {
        return textExercicio;
    }

    public String getTextDuracao() {
        return textDuracao;
    }

    public String getTextCalorias(){
        return textCalorias;
    }
}
