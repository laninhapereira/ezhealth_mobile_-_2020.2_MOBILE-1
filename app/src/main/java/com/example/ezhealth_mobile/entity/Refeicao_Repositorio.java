package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Refeicao_Repositorio extends ObjectDefault_Repositorio<Refeicao> {

    private static Refeicao_Repositorio instance;

    public static Refeicao_Repositorio getInstance(){
        if(instance == null)
            instance = new Refeicao_Repositorio();
        return instance;
    }

    private Refeicao_Repositorio(){
        popular();
    }

    private void popular(){
        ArrayList<Refeicao> list = new ArrayList<Refeicao>();
        Refeicao refeicao;

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(popularAlimentos());
        list.add(refeicao);

        refeicao = new Refeicao("Meu almoço 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(popularAlimentos());
        list.add(refeicao);

        refeicao = new Refeicao("Meu jantar 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(popularAlimentos());
        list.add(refeicao);

        refeicao = new Refeicao("Meu lanche da tarde 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(popularAlimentos());
        list.add(refeicao);

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(popularAlimentos());
        list.add(refeicao);

        super.setList(list);

        super.setTitleListItens("Refeições personalizadas");
    }


    public static ArrayList<Alimento> popularAlimentos(){
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
