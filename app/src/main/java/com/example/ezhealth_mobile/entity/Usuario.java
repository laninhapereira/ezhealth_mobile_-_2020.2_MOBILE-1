package com.example.ezhealth_mobile.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private String id;
    private String teste;
    private String nomeCompleto;
    private String cpf;
    private String crn;
    private String sexo;
    private String altura;
    private String peso;
    private String objetivo;
    private String intolerancias;
    private String doencas;

    public Usuario(String id, String teste) {
        this.id = id;
        this.teste = teste;
    }

    public Usuario(String id, String teste, String nomeCompleto, String cpf, String crn, String sexo, String altura, String peso, String objetivo, String intolerancias, String doencas) {
        this.id = id;
        this.teste = teste;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.crn = crn;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.objetivo = objetivo;
        this.intolerancias = intolerancias;
        this.doencas = doencas;
    }

    public Usuario() {
    }

    //Construtor protegido, para mapear todos os atributos para conseguir pegar de volta o seu estado
    protected Usuario(Parcel in) {
        id = in.readString();
        teste = in.readString();
        nomeCompleto = in.readString();
        cpf = in.readString();
        crn = in.readString();
        sexo = in.readString();
        altura = in.readString();
        peso = in.readString();
        objetivo = in.readString();
        intolerancias = in.readString();
        doencas = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public String getNomeCompleto() { return nomeCompleto; }

    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCrn() { return crn; }

    public void setCrn(String crn) { this.crn = crn; }

    public String getSexo() { return sexo; }

    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getAltura() { return altura; }

    public void setAltura(String altura) { this.altura = altura; }

    public String getPeso() { return peso; }

    public void setPeso(String peso) { this.peso = peso; }

    public String getObjetivo() { return objetivo; }

    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public String getIntolerancias() { return intolerancias; }

    public void setIntolerancias(String intolerancias) { this.intolerancias = intolerancias; }

    public String getDoencas() { return doencas; }

    public void setDoencas(String doencas) { this.doencas = doencas; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(teste);
        parcel.writeString(nomeCompleto);
        parcel.writeString(cpf);
        parcel.writeString(crn);
        parcel.writeString(sexo);
        parcel.writeString(altura);
        parcel.writeString(peso);
        parcel.writeString(objetivo);
        parcel.writeString(intolerancias);
        parcel.writeString(doencas);
    }
}
