package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;
import java.util.Random;

public class Alimento_Repositorio extends ObjectDefault_Repositorio {

    public Alimento_Repositorio(){
        super.setList(new ArrayList<>());
    }

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

    public static ArrayList<ObjectDefault> popularAlimentos(){
        ArrayList<ObjectDefault> list = new ArrayList<>();

        list.add(new Alimento("Banana", "100", "g" , "420"));
        list.add(new Alimento("Caju", "130", "g" , "300"));
        list.add(new Alimento("Mamão", "140", "g" , "320"));
        list.add(new Alimento("Pera", "120", "g" , "400"));
        list.add(new Alimento("Morango", "110", "g" , "350"));
        list.add(new Alimento("Maracujá", "130", "g" , "310"));
        list.add(new Alimento("Coca-Cola", "140", "ml" , "220"));
        list.add(new Alimento("Arroz", "150", "g" , "160"));
        list.add(new Alimento("Feijão", "120", "g" , "510"));
        list.add(new Alimento("Presunto", "110", "g" , "120"));

        ArrayList<ObjectDefault> listFinal = new ArrayList<>();

        Random random = new Random();

        for (int i=0; i < random.nextInt(5)+1; i++) // Esse random decide quantos alimentos a refeição terá
            listFinal.add(list.get(random.nextInt(10)));  // Esse random decide qual dos 10 alimentos a refeição terá

        return listFinal;
    }
}
