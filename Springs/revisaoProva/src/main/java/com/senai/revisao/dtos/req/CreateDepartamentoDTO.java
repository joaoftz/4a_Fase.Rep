package com.senai.revisao.dtos.req;

public class CreateDepartamentoDTO {

    private String nome;
    private String gerente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

}
