package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Alimento_Repositorio extends ObjectDefault_Repositorio<Alimento> {

    private static Alimento_Repositorio instance;

    public static Alimento_Repositorio getInstance(){
        if(instance == null)
            instance = new Alimento_Repositorio();
        return instance;
    }

    private Alimento_Repositorio(){
        popular();
    }

    private void popular(){
        ArrayList<Alimento> list = new ArrayList<Alimento>();

        list.add(new Alimento("Banana", "100", "g" , "320"));
        list.add(new Alimento("Caju", "100", "g" , "320"));
        list.add(new Alimento("Mamão", "100", "g" , "320"));
        list.add(new Alimento("Pera", "100", "g" , "320"));
        list.add(new Alimento("Morango", "100", "g" , "320"));
        list.add(new Alimento("Banana", "100", "g" , "320"));
        list.add(new Alimento("Caju", "100", "g" , "320"));
        list.add(new Alimento("Mamão", "100", "g" , "320"));
        list.add(new Alimento("Pera", "100", "g" , "320"));
        list.add(new Alimento("Morango", "100", "g" , "320"));

        super.setList(list);

        super.setTitleListItens("Café da manhã");
    }

}
