package com.example.ezhealth_mobile.entity;

public class Example_Item_Refeicao {

    private int mImageResource;
    private String textRefeicao;
    private String textMassa;
    private String textCalorias;


    public Example_Item_Refeicao(String text1, String text2, String text3){
        //mImageResource = imageResource;
        textRefeicao = text1;
        textMassa = text2;
        textCalorias = text3;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getTextRefeicao() {
        return textRefeicao;
    }

    public String getTextMassa() {
        return textMassa;
    }

    public String getTextCalorias(){
        return textCalorias;
    }

}