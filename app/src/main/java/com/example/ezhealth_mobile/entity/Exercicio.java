package com.example.ezhealth_mobile.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercicio extends ObjectDefault implements Parcelable {

    public Exercicio(String nome, int quantidade, String unidadeMedida, int calorias){
        super(nome, quantidade, unidadeMedida, calorias);
    }

    protected Exercicio(Parcel in) {
        super(in);
    }

    public Exercicio() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Exercicio> CREATOR = new Creator<Exercicio>() {
        @Override
        public Exercicio createFromParcel(Parcel in) {
            return new Exercicio(in);
        }

        @Override
        public Exercicio[] newArray(int size) {
            return new Exercicio[size];
        }
    };
}
