package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;


public abstract class ObjectDefault_Repositorio<T> {

    private ArrayList<T> list;
    private static String titleListItens = "";

    public void setList(ArrayList<T> list){
        this.list = list;
    }

    public ArrayList<T> getList(){
        return list;
    }

    public void add(T t){
        list.add(t);
    }

    public void delItemList(int position){
        list.remove(position);
    }

    public T getItemList(int position){
        return list.get(position);
    }

    public static String getTitleListItens() {
        return titleListItens;
    }

    public static void setTitleListItens(String title) {
        titleListItens = title;
    }
}
