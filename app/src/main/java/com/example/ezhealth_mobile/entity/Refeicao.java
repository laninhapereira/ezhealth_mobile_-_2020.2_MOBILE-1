package com.example.ezhealth_mobile.entity;


import android.os.Parcel;
import android.os.Parcelable;

public class Refeicao extends ObjectDefault implements Parcelable {

    private ObjectDefault_Repositorio repAlimentos;
    private String tipoRefeicao;

    public Refeicao(String nome, int quantidade, String unidadeMedida, int calorias, String tipoRefeicao){
        super(nome, quantidade, unidadeMedida, calorias);
        this.tipoRefeicao = tipoRefeicao;
        repAlimentos = new ObjectDefault_Repositorio();
    }

    protected Refeicao(Parcel in) {
        super(in);
        tipoRefeicao = in.readString();
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

    public int getCarboidratos(){
        Integer total = 0;
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getCarboidratos();
        return total;
    }

    public int getProteinas(){
        Integer total = 0;
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getProteinas();
        return total;
    }

    public int getGorduras(){
        Integer total = 0;
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getGorduras();
        return total;
    }

    public int getCalorias(){
        Integer total = 0;
        for (ObjectDefault obj: repAlimentos.getList())
            total += ((Alimento)obj).getCalorias();
        return total;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(tipoRefeicao);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Refeicao> CREATOR = new Creator<Refeicao>() {
        @Override
        public Refeicao createFromParcel(Parcel in) {
            return new Refeicao(in);
        }

        @Override
        public Refeicao[] newArray(int size) {
            return new Refeicao[size];
        }
    };

}
