package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Refeicao extends ObjectDefault{

    private Alimento_Repositorio repAlimentos;

    public Refeicao(String nome, String quantidade, String unidadeMedida, String calorias){
        super(nome, quantidade, unidadeMedida, calorias);
        repAlimentos = new Alimento_Repositorio();
    }

    public void setRepAlimentos(Alimento_Repositorio repAlimentos){
        this.repAlimentos = repAlimentos;
    }

    public Alimento_Repositorio getRepAlimentos(){
        return this.repAlimentos;
    }

}
