package com.senai.revisao.models;

public class Futebol extends Projeto {

    @Override
    public double calcularRendaMes(int qtdPontos, double renda) {
        if (qtdPontos >= 3) { 
            return renda;
        }

        return this.renda;
    }
}
