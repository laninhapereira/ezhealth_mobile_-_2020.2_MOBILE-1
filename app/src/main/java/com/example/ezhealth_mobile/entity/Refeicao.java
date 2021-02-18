package com.example.ezhealth_mobile.entity;

import java.util.ArrayList;

public class Refeicao extends ObjectDefault{

    private Alimento_Repositorio repAlimentos;
    private String tipoRefeicao;

    public Refeicao(String nome, String quantidade, String unidadeMedida, String calorias, String tipoRefeicao){
        super(nome, quantidade, unidadeMedida, calorias);
        this.tipoRefeicao = tipoRefeicao;
        repAlimentos = new Alimento_Repositorio();
    }

    public void setRepAlimentos(Alimento_Repositorio repAlimentos){
        this.repAlimentos = repAlimentos;
    }

    public Alimento_Repositorio getRepAlimentos(){
        return this.repAlimentos;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }
}
