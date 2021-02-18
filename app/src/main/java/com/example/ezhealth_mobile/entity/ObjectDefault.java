package com.example.ezhealth_mobile.entity;

public abstract class ObjectDefault {

    private String nome;
    private String quantidade;
    private String unidadeMedida;
    private String calorias;

    public ObjectDefault(String nome, String quantidade, String unidadeMedida, String calorias) {
        this.nome = (nome != null)? nome : "Not named";
        this.quantidade = (quantidade != null && Integer.parseInt(quantidade) >= 0)? quantidade : "0";
        this.unidadeMedida = (unidadeMedida != null)? unidadeMedida : "qtd";
        this.calorias = (calorias != null && Integer.parseInt(calorias) >= 0)? calorias : "0";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

}
