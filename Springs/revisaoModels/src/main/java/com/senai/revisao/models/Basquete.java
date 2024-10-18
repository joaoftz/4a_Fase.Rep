package com.senai.revisao.models;

public class Basquete extends Projeto {

    @Override
    public double calcularRendaMes(int qtdPontos, double renda) {
        if (qtdPontos >= 15) {
            return renda + (renda * 0.10);
        }

        return this.renda;
    }

}
