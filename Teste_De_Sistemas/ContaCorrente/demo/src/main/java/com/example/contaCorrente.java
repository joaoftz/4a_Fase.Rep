package com.example;

public class contaCorrente {
    
    private double saldo;
    private String nome;

    
    public contaCorrente(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    // Get e Set
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //depósito
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    //saque
    public boolean sacar(double valor) {
        if (valor > saldo) {
            return false;  
        } else {
            this.saldo -= valor;
            return true;
        }
    }
}

