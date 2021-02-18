package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Exercicio_Repositorio extends ObjectDefault_Repositorio {

    public Exercicio_Repositorio(){
        popular();
    }

    public ArrayList<ObjectDefault> popular(){
        ArrayList<ObjectDefault> list = new ArrayList<>();

        list.add(new Exercicio("Correr", "30", "km" ,"200"));
        list.add(new Exercicio("Dançar", "30", "km" ,"200"));
        list.add(new Exercicio("Andar de Bicicleta", "30", "km" ,"200"));
        list.add(new Exercicio("Nadar", "30", "km" ,"200"));
        list.add(new Exercicio("Correr", "30", "km" ,"200"));
        list.add(new Exercicio("Dançar", "30", "km" ,"200"));
        list.add(new Exercicio("Andar de Bicicleta", "30", "km" ,"200"));
        list.add(new Exercicio("Nadar", "30", "km" ,"200"));
        list.add(new Exercicio("Correr", "30", "km" ,"200"));
        list.add(new Exercicio("Dançar", "30", "km" ,"200"));
        list.add(new Exercicio("Andar de Bicicleta", "30", "km" ,"200"));
        list.add(new Exercicio("Nadar", "30", "km" ,"200"));

        super.setList(list);
        return list;
    }

}
