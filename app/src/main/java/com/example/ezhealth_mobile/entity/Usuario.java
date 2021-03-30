package com.example.ezhealth_mobile.entity;

public class Usuario {

    private String id;
    private String teste;

    public Usuario(String id, String teste) {
        this.id = id;
        this.teste = teste;
    }

    public Usuario() {
    }

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


}
