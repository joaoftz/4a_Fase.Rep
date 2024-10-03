package com.example.recuperacaoprova.entities;

import jakarta.persistence.Column;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "historico")
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_adocao")
    private String dataAdocao;

    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private AdotantesEntity adotantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(String dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public AdotantesEntity getAdotantes() {
        return adotantes;
    }

    public void setAdotantes(AdotantesEntity adotantes) {
        this.adotantes = adotantes;
    }



    
}
