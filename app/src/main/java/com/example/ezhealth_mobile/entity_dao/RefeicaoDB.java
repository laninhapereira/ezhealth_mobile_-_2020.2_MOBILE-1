package com.example.ezhealth_mobile.entity_dao;

import java.util.Date;

public class RefeicaoDB {

    private int position;
    private String nome;
    private int calorias;
    private String tipoRefeicao;
    private Date data;
    private boolean diaria;

    public int getPosition() {
        return position;
    }

    public void setPosition(int id) {
        this.position = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isDiaria() {
        return diaria;
    }

    public void setDiaria(boolean diaria) {
        this.diaria = diaria;
    }

}
