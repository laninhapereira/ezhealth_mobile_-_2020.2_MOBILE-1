package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Exercicio_Repositorio extends ObjectDefault_Repositorio {

    private static Exercicio_Repositorio instance;

    public static Exercicio_Repositorio getInstance(){
        if(instance == null)
            instance = new Exercicio_Repositorio();
        return instance;
    }

    private Exercicio_Repositorio(){
        popular();
    }

    public ArrayList<ObjectDefault> popular(){
        ArrayList<ObjectDefault> list = new ArrayList<>();

        list.add(new Exercicio("Correr", "30", "min" ,"200"));
        list.add(new Exercicio("Dançar", "30", "min" ,"200"));
        list.add(new Exercicio("Andar de Bicicleta", "30", "min" ,"200"));
        list.add(new Exercicio("Nadar", "30", "min" ,"200"));
        list.add(new Exercicio("Correr", "30", "min" ,"200"));
        list.add(new Exercicio("Dançar", "30", "min" ,"200"));
        list.add(new Exercicio("Esteira", "30", "min" ,"200"));
        list.add(new Exercicio("Flexões", "30", "min" ,"200"));
        list.add(new Exercicio("Leg Curl", "30", "min" ,"200"));
        list.add(new Exercicio("Abdominal ", "30", "min" ,"200"));
        list.add(new Exercicio("Trícep extension", "30", "min" ,"200"));
        list.add(new Exercicio("Supino declinado", "30", "min" ,"200"));

        super.setList(list);
        return list;
    }

    public String getDuracaoTotal(){
        Integer total = 0;
        for (ObjectDefault t: super.getList())
            total += Integer.parseInt(((Alimento)t).getGorduras());
        return total.toString();
    }

}
