package com.example.ezhealth_mobile.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private String id;
    private String teste;

    public Usuario(String id, String teste) {
        this.id = id;
        this.teste = teste;
    }

    public Usuario() {
    }

    //Construtor protegido, para mapear todos os atributos para conseguir pegar de volta o seu estado
    protected Usuario(Parcel in) {
        id = in.readString();
        teste = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(teste);
    }
}
