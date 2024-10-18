package com.senai.revisao.models;

import java.util.ArrayList;
import java.util.List;

import com.senai.revisao.enums.EstadoCivil;

public class Funcionario {

    private long id;
    private String nome;
    private String email;
    private EstadoCivil estadoCivil;
    private Departamento departamento;

    private List<Projeto> projetos;

    public Funcionario() {
        this.projetos = new ArrayList<>();
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

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void setProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
