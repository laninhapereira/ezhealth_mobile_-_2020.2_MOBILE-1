package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;
import java.util.Random;

public class Refeicao_Repositorio extends ObjectDefault_Repositorio {

    private static Refeicao_Repositorio instance;
    private static ArrayList<ObjectDefault> refeicoesDiarias;
    private static ArrayList<ObjectDefault> refeicoesPersonalizadas;

    public static Refeicao_Repositorio getInstance(){
        if(instance == null)
            instance = new Refeicao_Repositorio();
        return instance;
    }

    private Refeicao_Repositorio(){
        refeicoesPersonalizadas();
        refeicoesDiarias();
    }

    private void refeicoesPersonalizadas(){
        refeicoesPersonalizadas = new ArrayList<>();
        Refeicao refeicao;

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesPersonalizadas.add(refeicao);

        refeicao = new Refeicao("Meu almoço 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesPersonalizadas.add(refeicao);

        refeicao = new Refeicao("Meu jantar 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesPersonalizadas.add(refeicao);

        refeicao = new Refeicao("Meu lanche da tarde 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesPersonalizadas.add(refeicao);

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesPersonalizadas.add(refeicao);

        refeicao = new Refeicao("Lanche pós-treino", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesPersonalizadas.add(refeicao);

        super.setTitleListItens("Refeições personalizadas");
    }


    private static void refeicoesDiarias(){
        refeicoesDiarias = new ArrayList<>();
        Refeicao refeicao;

        refeicao = new Refeicao("Café da manhã", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesDiarias.add(refeicao);

        refeicao = new Refeicao("Lanche da Manhã", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesDiarias.add(refeicao);

        refeicao = new Refeicao("Almoço", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesDiarias.add(refeicao);

        refeicao = new Refeicao("Lanche da Tarde", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesDiarias.add(refeicao);

        refeicao = new Refeicao("Jantar", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(Alimento_Repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        refeicoesDiarias.add(refeicao);

    }

    public static ArrayList<ObjectDefault> getRefeicoesDiarias() {
        return refeicoesDiarias;
    }

    public static void setRefeicoesDiarias(ArrayList<ObjectDefault> refeicoesDiarias) {
        Refeicao_Repositorio.refeicoesDiarias = refeicoesDiarias;
    }

    public static ArrayList<ObjectDefault> getRefeicoesPersonalizadas() {
        return refeicoesPersonalizadas;
    }

    public static void setRefeicoesPersonalizadas(ArrayList<ObjectDefault> refeicoesPersonalizadas) {
        Refeicao_Repositorio.refeicoesPersonalizadas = refeicoesPersonalizadas;
    }
}
