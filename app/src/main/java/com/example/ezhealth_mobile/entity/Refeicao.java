package com.example.ezhealth_mobile.entity;



import com.example.ezhealth_mobile.entity_dao.RefeicaoDB;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Refeicao extends ObjectDefault implements Serializable {

    private List<Alimento> listAlimento;
    private String tipoRefeicao;
    private Date data;
    private boolean diaria;

    public Refeicao(String nome, int quantidade, String unidadeMedida, int calorias, String tipoRefeicao){
        super(nome, quantidade, unidadeMedida, calorias);
        this.tipoRefeicao = tipoRefeicao;
    }

    public Refeicao(RefeicaoDB ref){
        setPosition(ref.getPosition());
        setNome(ref.getNome());
        setCalorias(ref.getCalorias());
        setData(ref.getData());
        setDiaria(ref.isDiaria());
        setTipoRefeicao(ref.getTipoRefeicao());
    }

    public Refeicao() {
        super();
    }

    public void setListAlimentos(List listAlimentos){
        listAlimento = listAlimentos;
    }

    public List<Alimento> getListAlimentos(){
        return listAlimento;
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

    public int getCarboidratos(){
        Integer total = 0;

        if(listAlimento == null || listAlimento.size() == 0)
            return total;

        for (Alimento obj: listAlimento)
            total += obj.getCarboidratos();
        return total;
    }

    public int getProteinas(){
        Integer total = 0;

        if(listAlimento == null || listAlimento.size() == 0)
            return total;

        for (Alimento obj: listAlimento)
            total += obj.getProteinas();
        return total;
    }

    public int getGorduras(){
        Integer total = 0;

        if(listAlimento == null || listAlimento.size() == 0)
            return total;

        for (Alimento obj: listAlimento)
            total += obj.getGorduras();
        return total;
    }

    public int getCalorias(){
        Integer total = 0;

        if(listAlimento == null || listAlimento.size() == 0)
            return total;

        for (Alimento obj: listAlimento)
            total += obj.getCalorias();
        return total;
    }



    public RefeicaoDB toRefeicaoDB(){
        RefeicaoDB ref = new RefeicaoDB();

        ref.setPosition(getPosition());
        ref.setNome(getNome());
        ref.setCalorias(getCalorias());
        ref.setData(getData());
        ref.setDiaria(isDiaria());
        ref.setTipoRefeicao(getTipoRefeicao());

        return ref;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Refeicao{" +
                "listAlimento=" + listAlimento +
                ", tipoRefeicao='" + tipoRefeicao + '\'' +
                ", data=" + data +
                ", diaria=" + diaria +
                '}';
    }

}
