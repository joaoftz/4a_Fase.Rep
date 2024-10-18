package com.senai.revisao.models;

import com.senai.revisao.interfaces.IProjeto;

public abstract class Projeto implements IProjeto {
    protected final double renda = 500;

    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
