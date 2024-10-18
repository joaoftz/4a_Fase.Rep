package com.senai.revisao.dtos.req;

import java.util.List;

public class CreateFuncionarioDTO {

    private String nome;
    private String email;
    private CreateDepartamentoDTO departamento;
    private List<CreateProjetoDTO> projetos;

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

    public CreateDepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(CreateDepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public List<CreateProjetoDTO> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<CreateProjetoDTO> projetos) {
        this.projetos = projetos;
    }
}
