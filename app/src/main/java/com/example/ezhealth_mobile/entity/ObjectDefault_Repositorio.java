package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class ObjectDefault_Repositorio{

    private ArrayList<ObjectDefault> list;

    public ObjectDefault_Repositorio() {
        this.list = new ArrayList<>();
    }

    public void setList(ArrayList<ObjectDefault> list){
        this.list = list;
    }

    public ArrayList<ObjectDefault> getList(){
        return list;
    }

    public void add(ObjectDefault t){
        list.add(t);
    }

    public void delItemList(int position){
        list.remove(position);
    }

    public ObjectDefault getItemList(int position){
        return list.get(position);
    }

    public int getCaloriasTotais(){
        Integer total = 0;
        for (ObjectDefault t: list)
            total += t.getCalorias();
        return total;
    }

    public int getQuantidadeTotais(){
        Integer total = 0;
        for (ObjectDefault t: list)
            total += t.getQuantidade();
        return total;
    }

    public ObjectDefault getItemList(String titulo){
        for(ObjectDefault obj: list)
            if(obj.getNome().equals(titulo))
                return obj;
        return null;
    }

    public ObjectDefault setItemList(String titulo, ObjectDefault objectDefault){
        for(ObjectDefault obj: list)
            if(obj.getNome().equals(titulo))
                return obj = objectDefault;
        return null;
    }

}
