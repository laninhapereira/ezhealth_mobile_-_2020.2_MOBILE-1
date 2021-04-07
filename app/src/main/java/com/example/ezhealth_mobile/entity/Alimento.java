package com.example.ezhealth_mobile.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.ezhealth_mobile.entity_dao.AlimentoDB;

import java.io.Serializable;

public class Alimento extends ObjectDefault implements Serializable {

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


    public AlimentoDB toAlimentoDB(){
        AlimentoDB ref = new AlimentoDB();

        ref.setPosition(getPosition());
        ref.setNome(getNome());
        ref.setCalorias(getCalorias());
        ref.setCarboidratos(getCarboidratos());
        ref.setGorduras(getGorduras());
        ref.setProteinas(getGorduras());
        ref.setQuantidade(getQuantidade());
        ref.setUnidadeMedida(getUnidadeMedida());

        return ref;
    }
}
