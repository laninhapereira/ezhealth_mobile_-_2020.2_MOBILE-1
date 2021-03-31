package com.example.ezhealth_mobile.entity;

public class Alimento extends ObjectDefault{

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
}
