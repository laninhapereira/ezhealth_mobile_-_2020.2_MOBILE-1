package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Refeicao_Repositorio extends ObjectDefault_Repositorio {

    private static ArrayList<ObjectDefault> refeicoesDiarias = refeicoesDiarias();
    private static ArrayList<ObjectDefault> refeicoesPersonalizadas = refeicoesPersonalizadas();

    private static ArrayList<ObjectDefault> refeicoesPersonalizadas(){
        Alimento_Repositorio alimento_repositorio = new Alimento_Repositorio();
        ArrayList<ObjectDefault> list = new ArrayList<>();
        Refeicao refeicao;

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu almoço 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu jantar 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu lanche da tarde 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Meu café da manhã 1", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Lanche pós-treino", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        return list;
    }

    private static ArrayList<ObjectDefault> refeicoesDiarias(){
        Alimento_Repositorio alimento_repositorio = new Alimento_Repositorio();
        ArrayList<ObjectDefault> list = new ArrayList<>();
        Refeicao refeicao;

        refeicao = new Refeicao("Café da manhã", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Lanche da Manhã", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Almoço", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Lanche da Tarde", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        refeicao = new Refeicao("Jantar", "100", "g" , "320");
        refeicao.getRepAlimentos().setList(alimento_repositorio.popularAlimentos());
        refeicao.setCalorias(refeicao.getRepAlimentos().getCaloriasTotais());
        refeicao.setQuantidade(refeicao.getRepAlimentos().getQuantidadeTotais());
        list.add(refeicao);

        return list;
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
