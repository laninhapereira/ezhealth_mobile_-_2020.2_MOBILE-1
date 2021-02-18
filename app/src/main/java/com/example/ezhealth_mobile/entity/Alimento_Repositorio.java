package com.example.ezhealth_mobile.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Alimento_Repositorio extends ObjectDefault_Repositorio {

    private static Alimento_Repositorio instance;

    public static Alimento_Repositorio getInstance(){
        if(instance == null)
            instance = new Alimento_Repositorio();
        return instance;
    }

    private Alimento_Repositorio(){
        getListaAlimentosGeral();
    }

    public ArrayList<ObjectDefault> getListaAlimentosGeral(){
        ArrayList<ObjectDefault> list = new ArrayList<>();

        list.add(new Alimento("Banana", "100", "g" , "420", "80", "20", "52"));
        list.add(new Alimento("Caju", "130", "g" , "300", "50", "10", "50"));
        list.add(new Alimento("Mamão", "140", "g" , "320", "70", "20", "24"));
        list.add(new Alimento("Pera", "120", "g" , "400", "24", "43", "52"));
        list.add(new Alimento("Morango", "110", "g" , "350", "10", "45", "12"));
        list.add(new Alimento("Maracujá", "130", "g" , "310", "55", "20", "52"));
        list.add(new Alimento("Coca-Cola", "140", "ml" , "220", "50", "20", "14"));
        list.add(new Alimento("Arroz", "150", "g" , "160", "40", "55", "58"));
        list.add(new Alimento("Feijão", "120", "g" , "510", "60", "20", "52"));
        list.add(new Alimento("Presunto", "110", "g" , "120", "25", "60", "10"));

        super.setList(list);
        return list;
    }

    public ArrayList<ObjectDefault> popularAlimentos(){

        ArrayList<ObjectDefault> listFinal = new ArrayList<>();

        Random random = new Random();

        for (int i=0; i < random.nextInt(5)+1; i++)  // Esse random decide quantos alimentos a refeição terá
            listFinal.add( super.getList().get(random.nextInt(10)));  // Esse random decide qual dos 10 alimentos a refeição terá


        return listFinal;
    }

    public String getCarboidratosTotais(){
        Integer total = 0;
        for (ObjectDefault t: super.getList())
            total += Integer.parseInt(((Alimento)t).getCarboidratos());
        return total.toString();
    }

    public String getProteinasTotais(){
        Integer total = 0;
        for (ObjectDefault t: super.getList())
            total += Integer.parseInt(((Alimento)t).getProteinas());
        return total.toString();
    }

    public String getGordurasTotais(){
        Integer total = 0;
        for (ObjectDefault t: super.getList())
            total += Integer.parseInt(((Alimento)t).getGorduras());
        return total.toString();
    }

}
