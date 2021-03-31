package com.example.ezhealth_mobile.entity;

public abstract class ObjectDefault {

    private String nome;
    private int quantidade;
    private String unidadeMedida;
    private int calorias;

    public ObjectDefault(String nome, int quantidade, String unidadeMedida, int calorias) {
        this.nome = (nome != null)? nome : "Not named";
        this.quantidade = (quantidade <= 0)? quantidade : 0;
        this.unidadeMedida = (unidadeMedida != null)? unidadeMedida : "qtd";
        this.calorias = (calorias < 0)? calorias : 0;
    }

    public ObjectDefault() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

}
