package com.example.recuperacaoprova.dtos.req;

import java.util.List;

public class CreateAnimaisDTO {
    
    private String nome;
    private String tipo;
    private CreateHistoricoDTO historico;
    private List<CreateAdotantesDTO> adotantes;
    
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
    public CreateHistoricoDTO getHistorico() {
        return historico;
    }
    public void setHistorico(CreateHistoricoDTO historico) {
        this.historico = historico;
    }
    public List<CreateAdotantesDTO> getAdotantes() {
        return adotantes;
    }
    public void setAdotantes(List<CreateAdotantesDTO> adotantes) {
        this.adotantes = adotantes;
    }

}
