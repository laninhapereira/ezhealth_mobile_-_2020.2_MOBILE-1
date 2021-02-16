package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Exercicio_Repositorio extends ObjectDefault_Repositorio<Exercicio> {

    private static Exercicio_Repositorio instance;

    public static Exercicio_Repositorio getInstance(){
        if(instance == null)
            instance = new Exercicio_Repositorio();
        return instance;
    }

    private Exercicio_Repositorio(){
        popular();
    }

    private void popular(){
        ArrayList<Exercicio> list = new ArrayList<>();

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

        super.setTitleListItens("Lista de exercicios");
    }

}
