package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class RepositoryObjectDefault {

    private static ArrayList<ObjectDefault> listObject = new ArrayList<ObjectDefault>();

    public static void setList(ArrayList<ObjectDefault> list){
        listObject = list;
    }

    public static ArrayList<ObjectDefault> getList(){
        return listObject;
    }

    public static void add(ObjectDefault objectDefault){
        listObject.add(objectDefault);
    }

    public static void delItemList(int position){
        listObject.remove(position);
    }

    public static ObjectDefault getItemList(int position){
        return listObject.get(position);
    }
}
