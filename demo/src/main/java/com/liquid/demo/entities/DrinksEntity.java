package com.liquid.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "drinks_liquid")
public class DrinksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_drink")
    private String nomeDrink;

    @Column(name = "valor")
    private String valor;

    @Column(name = "alcoolico")
    private Boolean alcoolico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
