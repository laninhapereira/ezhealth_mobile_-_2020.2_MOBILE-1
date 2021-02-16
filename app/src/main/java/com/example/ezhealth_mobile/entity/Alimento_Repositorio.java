package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Alimento_Repositorio extends ObjectDefault_Repositorio<Alimento> {

    public static ArrayList<Alimento> getListaAlimentosGeral(){
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

        return list;
    }

}
