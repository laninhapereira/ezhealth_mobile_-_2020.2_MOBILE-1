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

        list.add(new Refeicao("Meu café da manhã 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu almoço 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu jantar 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu lanche da tarde 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu café da manhã 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu almoço 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu jantar 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu lanche da tarde 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu café da manhã 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu almoço 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu jantar 1", "100", "g" , "320"));
        list.add(new Refeicao("Meu lanche da tarde 1", "100", "g" , "320"));

        super.setList(list);

        super.setTitleListItens("Refeições personalizadas");
    }


}
