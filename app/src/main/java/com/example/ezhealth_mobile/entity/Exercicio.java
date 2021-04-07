package com.example.ezhealth_mobile.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Exercicio extends ObjectDefault implements Serializable {

    public Exercicio(String nome, int quantidade, String unidadeMedida, int calorias){
        super(nome, quantidade, unidadeMedida, calorias);
    }

    public Exercicio() {
        super();
    }

}
