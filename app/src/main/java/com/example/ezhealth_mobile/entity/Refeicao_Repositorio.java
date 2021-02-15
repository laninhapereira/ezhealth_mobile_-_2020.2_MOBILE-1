package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Refeicao_Repositorio {

    private static ArrayList<Refeicao> list = popular();
    private static String titleListItens = "";

    private static ArrayList<Refeicao> popular(){
        list = new ArrayList<Refeicao>();
        list.add(new Refeicao("Meu café da manhã 1", "100", "320"));
        list.add(new Refeicao("Meu almoço 1", "100", "320"));
        list.add(new Refeicao("Meu jantar 1", "100", "320"));
        list.add(new Refeicao("Meu lanche da tarde 1", "100", "320"));
        list.add(new Refeicao("Meu café da manhã 1", "100", "320"));
        list.add(new Refeicao("Meu almoço 1", "100", "320"));
        list.add(new Refeicao("Meu jantar 1", "100", "320"));
        list.add(new Refeicao("Meu lanche da tarde 1", "100", "320"));
        list.add(new Refeicao("Meu café da manhã 1", "100", "320"));
        list.add(new Refeicao("Meu almoço 1", "100", "320"));
        list.add(new Refeicao("Meu jantar 1", "100", "320"));
        list.add(new Refeicao("Meu lanche da tarde 1", "100", "320"));
        return list;
    }

    public static void setList(ArrayList<Refeicao> list){
        list = list;
    }

    public static ArrayList<Refeicao> getList(){
        return (list==null)? new Refeicao_Repositorio().list: list;
    }

    public static void add(Refeicao refeicao){
        list.add(refeicao);
    }

    public static void delItemList(int position){
        list.remove(position);
    }

    public static Refeicao getItemList(int position){
        return list.get(position);
    }

    public static String getTitleListItens() {
        return titleListItens;
    }

    public static void setTitleListItens(String title) {
        titleListItens = title;
    }
}
