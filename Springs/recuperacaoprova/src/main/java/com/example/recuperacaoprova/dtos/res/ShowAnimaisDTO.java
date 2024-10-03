package com.example.recuperacaoprova.dtos.res;

import java.util.List;

public class ShowAnimaisDTO {
    
    private Long id;
    private String nome;
    private String tipo; 
    private ShowHistoricoDTO historico;
    private List<ShowAdotantesDTO> adotante;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public ShowHistoricoDTO getHistorico() {
        return historico;
    }
    public void setHistorico(ShowHistoricoDTO historico) {
        this.historico = historico;
    }
    public List<ShowAdotantesDTO> getAdotante() {
        return adotante;
    }
    public void setAdotante(List<ShowAdotantesDTO> adotante) {
        this.adotante = adotante;
    }
}
