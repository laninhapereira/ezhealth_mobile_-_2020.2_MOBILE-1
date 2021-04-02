package com.example.ezhealth_mobile.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private String id;
    private String senha;
    private String tipoUsuario;
    private String nomeCompleto;
    private String email;
    private String dataNascimento;
    private String cpf;
    private String crn;
    private String diaNasc;
    private String mesNasc;
    private String anoNasc;
    private String sexo;
    private String altura;
    private String peso;
    private String objetivo;
    private String intolerancias;
    private String doencas;


    public Usuario(String id, String senha, String tipoUsuario, String nomeCompleto, String cpf, String crn, String diaNasc, String mesNasc, String anoNasc,
                   String sexo, String altura, String peso, String objetivo, String intolerancias, String doencas) {
        this.id = id;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.crn = crn;
        this.diaNasc = diaNasc;
        this.mesNasc = mesNasc ;
        this.anoNasc = anoNasc;
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
        senha = in.readString();
        tipoUsuario = in.readString();
        nomeCompleto = in.readString();
        cpf = in.readString();
        crn = in.readString();
        diaNasc = in.readString();
        mesNasc = in.readString();
        anoNasc = in.readString();
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() { return nomeCompleto; }

    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCrn() { return crn; }

    public void setCrn(String crn) { this.crn = crn; }

    public String getDiaNasc() { return diaNasc; }

    public void setDiaNasc(String diaNasc) { this.diaNasc = diaNasc; }

    public String getMesNasc() { return mesNasc; }

    public void setMesNasc(String mesNasc) { this.mesNasc = mesNasc; }

    public String getAnoNasc() { return anoNasc; }

    public void setAnoNasc(String anoNasc) { this.anoNasc = anoNasc; }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoUsuario() { return tipoUsuario; }

    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public String getDataNascimento(){
        return diaNasc + "/" + mesNasc + "/" + anoNasc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(senha);
        parcel.writeString(tipoUsuario);
        parcel.writeString(nomeCompleto);
        parcel.writeString(cpf);
        parcel.writeString(crn);
        parcel.writeString(diaNasc);
        parcel.writeString(mesNasc);
        parcel.writeString(anoNasc);
        parcel.writeString(sexo);
        parcel.writeString(altura);
        parcel.writeString(peso);
        parcel.writeString(objetivo);
        parcel.writeString(intolerancias);
        parcel.writeString(doencas);
        parcel.writeString(dataNascimento);
        parcel.writeString(email);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", teste='" + senha + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", cpf='" + cpf + '\'' +
                ", crn='" + crn + '\'' +
                ", sexo='" + sexo + '\'' +
                ", altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", intolerancias='" + intolerancias + '\'' +
                ", doencas='" + doencas + '\'' +
                '}';
    }
}
