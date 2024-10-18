package com.senai.revisao.models;

public class Volei extends Projeto {

    @Override
    public double calcularRendaMes(int qtdPontos, double renda) {
        if (qtdPontos >= 42) {
            return renda + (renda * 0.10);
        }

        return this.renda;
    }
    
}
