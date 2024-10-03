package com.example.recuperacaoprova.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class AnimaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome")
    private String nome;

    @Column(name ="tipo")
    private String tipo;

    @OneToOne(mappedBy = "animais")
    private AdotantesEntity adotantes;

    @OneToMany(mappedBy = "animais")
    private List<HistoricoEntity> historico;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public AdotantesEntity getAdotantes() {
        return adotantes;
    }

    public void setAdotantes(AdotantesEntity adotantes) {
        this.adotantes = adotantes;
    }

    public List<HistoricoEntity> getHistorico() {
        return historico;
    }

    public void setHistorico(List<HistoricoEntity> historico) {
        this.historico = historico;
    }





    
}
