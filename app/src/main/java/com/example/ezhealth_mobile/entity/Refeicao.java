package com.example.ezhealth_mobile.entity;


public class Refeicao extends ObjectDefault{

    private ObjectDefault_Repositorio repAlimentos;
    private String tipoRefeicao;

    public Refeicao(String nome, int quantidade, String unidadeMedida, int calorias, String tipoRefeicao){
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
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getCarboidratos();
        return total.toString();
    }

    public String getProteinasTotais(){
        Integer total = 0;
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getProteinas();
        return total.toString();
    }

    public String getGordurasTotais(){
        Integer total = 0;
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getGorduras();
        return total.toString();
    }

    public String getCaloriasTotais(){
        Integer total = 0;
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getCalorias();
        return total.toString();
    }

}
