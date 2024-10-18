package com.senai.revisao.dtos.res;

import java.util.ArrayList;
import java.util.List;

public class ShowFuncionarioDTO {

    private Long id;
    private String nome;
    private String email;
    private ShowDepartamentoDTO departamento;
    private List<ShowProjetoDTO> projetos;

    public ShowFuncionarioDTO() {
        this.projetos = new ArrayList<>();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShowDepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(ShowDepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public List<ShowProjetoDTO> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ShowProjetoDTO> projetos) {
        this.projetos = projetos;
    }

    public void setProjeto(ShowProjetoDTO projetoDTO) {
        this.projetos.add(projetoDTO);
    }
}
