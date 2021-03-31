package com.example.ezhealth_mobile.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Alimento extends ObjectDefault implements Parcelable {

    private int carboidratos;
    private int proteinas;
    private int gorduras;

    public Alimento(String nome, int quantidade, String unidadeMedida, int calorias,
                    int carboidratos, int proteinas, int gorduras){
        super(nome, quantidade, unidadeMedida, calorias);
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
    }

    public Alimento() {
        super();
    }

    protected Alimento(Parcel in) {
        carboidratos = in.readInt();
        proteinas = in.readInt();
        gorduras = in.readInt();
    }


    public int getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(int carboidratos) {
        this.carboidratos = carboidratos;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getGorduras() {
        return gorduras;
    }

    public void setGorduras(int gorduras) {
        this.gorduras = gorduras;
    }

    public static final Creator<Alimento> CREATOR = new Creator<Alimento>() {
        @Override
        public Alimento createFromParcel(Parcel in) {
            return new Alimento(in);
        }

        @Override
        public Alimento[] newArray(int size) {
            return new Alimento[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(carboidratos);
        dest.writeInt(proteinas);
        dest.writeInt(gorduras);
    }
}
