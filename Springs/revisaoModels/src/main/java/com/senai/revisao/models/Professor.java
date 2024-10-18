package com.senai.revisao.models;

public class Professor  extends Funcionario2 {
    private String formacao;
    private String carteirinha;

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(String carteirinha) {
        this.carteirinha = carteirinha;
    }

    // Construtores, getters e setters
    
    public Professor(String email, String senha, String matricula) {
        super(email, senha, matricula);
        //TODO Auto-generated constructor stub
    }
    
}
