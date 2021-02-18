package com.example.ezhealth_mobile.entity;


public class Refeicao extends ObjectDefault{

    private ObjectDefault_Repositorio repAlimentos;
    private String tipoRefeicao;

    public Refeicao(String nome, String quantidade, String unidadeMedida, String calorias, String tipoRefeicao){
        super(nome, quantidade, unidadeMedida, calorias);
        this.tipoRefeicao = tipoRefeicao;
        repAlimentos = new ObjectDefault_Repositorio();
    }

    public void setRepAlimentos(Alimento_Repositorio repAlimentos){
        this.repAlimentos = repAlimentos;
    }

    public ObjectDefault_Repositorio getRepAlimentos(){
        return this.repAlimentos;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public String getCarboidratosTotais(){
        Integer total = 0;
        for (ObjectDefault t: repAlimentos.getList())
            total += Integer.parseInt(((Alimento)t).getCarboidratos());
        return total.toString();
    }

    public String getProteinasTotais(){
        Integer total = 0;
        for (ObjectDefault t: repAlimentos.getList())
            total += Integer.parseInt(((Alimento)t).getProteinas());
        return total.toString();
    }

    public String getGordurasTotais(){
        Integer total = 0;
        for (ObjectDefault t: repAlimentos.getList())
            total += Integer.parseInt(((Alimento)t).getGorduras());
        return total.toString();
    }

    public String getCaloriasTotais(){
        Integer total = 0;
        for (ObjectDefault t: repAlimentos.getList())
            total += Integer.parseInt(t.getCalorias());
        return total.toString();
    }

}
