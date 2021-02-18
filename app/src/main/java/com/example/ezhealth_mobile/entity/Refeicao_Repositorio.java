package com.example.ezhealth_mobile.entity;

import android.util.Log;

import java.util.ArrayList;

public class Refeicao_Repositorio extends ObjectDefault_Repositorio {

    private static Refeicao_Repositorio instance;

    public static Refeicao_Repositorio getInstance(){
        if(instance == null)
            instance = new Refeicao_Repositorio();
        return instance;
    }

    private Refeicao_Repositorio(){
        popular();
    }

    public ObjectDefault getItemList(String nome){
        Refeicao refeicao = (Refeicao) super.getItemList(nome);
        for(ObjectDefault objectDefault: refeicao.getRepAlimentos().getList())
            Log.d("a", "configuraPrimeiroaaaaaaaaaaaaaaaaaaaPainel: "+objectDefault.getNome());
        return refeicao;
    }

    public ArrayList<ObjectDefault> getListPersonalizada(){
        ArrayList<ObjectDefault> list = new ArrayList<>();
        for(ObjectDefault objectDefault: super.getList())
            if( ((Refeicao)objectDefault).getTipoRefeicao().equals("personalizada") )
                list.add(objectDefault);
        return list;
    }

    public ArrayList<ObjectDefault> getListDiaria(){
        ArrayList<ObjectDefault> list = new ArrayList<>();
        for(ObjectDefault objectDefault: super.getList())
            if( ((Refeicao)objectDefault).getTipoRefeicao().equals("diaria") )
                list.add(objectDefault);
        return list;
    }

    private void popular(){
        Alimento_Repositorio alimento_repositorio = new Alimento_Repositorio();
        ArrayList<ObjectDefault> list = new ArrayList<>();
        Refeicao refeicao;

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320", "personalizada");

        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu almoço 1", "100", "g" , "320", "personalizada");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu jantar 1", "100", "g" , "320", "personalizada");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu lanche da tarde 1", "100", "g" , "320", "personalizada");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320", "personalizada");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Lanche pós-treino", "100", "g" , "320", "personalizada");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        /////////////////////
        // Refeições diarias
        /////////////////////
        refeicao = new Refeicao("Café da manhã", "100", "g" , "320", "diaria");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Lanche da Manhã", "100", "g" , "320", "diaria");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Almoço", "100", "g" , "320", "diaria");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Lanche da Tarde", "100", "g" , "320", "diaria");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Jantar", "100", "g" , "320", "diaria");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        super.setList(list);
    }

}
