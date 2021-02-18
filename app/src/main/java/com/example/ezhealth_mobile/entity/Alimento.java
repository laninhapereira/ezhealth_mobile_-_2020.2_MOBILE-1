package com.example.ezhealth_mobile.entity;

public class Alimento extends ObjectDefault{

    private String carboidratos;
    private String proteinas;
    private String gorduras;

    public Alimento(String nome, String quantidade, String unidadeMedida, String calorias,
                    String carboidratos, String proteinas, String gorduras){
        super(nome, quantidade, unidadeMedida, calorias);
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
    }

    public String getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(String carboidratos) {
        this.carboidratos = carboidratos;
    }

    public String getProteinas() {
        return proteinas;
    }

    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    public String getGorduras() {
        return gorduras;
    }

    public void setGorduras(String gorduras) {
        this.gorduras = gorduras;
    }
}
