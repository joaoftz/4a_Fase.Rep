package com.liquid.demo.dtos.request;


public class CreateDrink {


    private String nomeDrink;
    private String valor;
    private Boolean alcoolico;

    public String getNomeDrink() {
        return nomeDrink;
    }
    public void setNomeDrink(String nomeDrink) {
        this.nomeDrink = nomeDrink;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public Boolean getAlcoolico() {
        return alcoolico;
    }
    public void setAlcoolico(Boolean alcoolico) {
        this.alcoolico = alcoolico;
    }
    
}