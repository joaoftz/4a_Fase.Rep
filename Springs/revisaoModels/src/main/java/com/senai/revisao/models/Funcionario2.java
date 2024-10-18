package com.senai.revisao.models;

public class Funcionario2 extends Usuario {
    private String matricula;
    private double salario;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Construtores, getters e setters
    public Funcionario2(String email, String senha, String matricula) {
        super(email, senha);
        this.matricula = matricula;
    }

    // Getters e Setters
}

