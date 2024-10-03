package com.senai.revisao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.revisao.dtos.req.CreateFuncionarioDTO;
import com.senai.revisao.dtos.req.CreateProjetoDTO;
import com.senai.revisao.dtos.res.ShowDepartamentoDTO;
import com.senai.revisao.dtos.res.ShowFuncionarioDTO;
import com.senai.revisao.dtos.res.ShowProjetoDTO;
import com.senai.revisao.entities.DepartamentoEntity;
import com.senai.revisao.entities.FuncionarioEntity;
import com.senai.revisao.entities.ProjetoEntity;
import com.senai.revisao.repositories.DepartamentoRepository;
import com.senai.revisao.repositories.FuncionarioRepository;
import com.senai.revisao.repositories.ProjetoRepository;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    ProjetoRepository projetoRepository;

    public void createFuncionario(CreateFuncionarioDTO dto) {

        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
        funcionarioEntity.setNome(dto.getNome());
        funcionarioEntity.setEmail(dto.getEmail());

        funcionarioEntity = funcionarioRepository.save(funcionarioEntity);

        DepartamentoEntity departamentoEntity = new DepartamentoEntity();
        departamentoEntity.setNome(dto.getDepartamento().getNome());
        departamentoEntity.setGerente(dto.getDepartamento().getGerente());
        departamentoEntity.setFuncionario(funcionarioEntity);

        departamentoEntity = departamentoRepository.save(departamentoEntity);

        List<ProjetoEntity> projetosEntity = new ArrayList<>();

        for (CreateProjetoDTO projetoDTO : dto.getProjetos()) {
            ProjetoEntity projetoEntity = new ProjetoEntity();
            projetoEntity.setNome(projetoDTO.getNome());
            projetoEntity.setDescricao(projetoDTO.getDescricao());
            projetoEntity.setFuncionario(funcionarioEntity);

            projetosEntity.add(projetoEntity);
        }

        projetoRepository.saveAll(projetosEntity);
    }

    public List<ShowFuncionarioDTO> getAllFuncionarios() {
        List<FuncionarioEntity> funcionariosEntity = funcionarioRepository.findAll();

        return funcionariosEntity
                .stream()
                .map(funcionario -> {
                    ShowFuncionarioDTO funcionarioDTO = new ShowFuncionarioDTO();
                    ShowDepartamentoDTO departamentoDTO = new ShowDepartamentoDTO();
                    List<ShowProjetoDTO> projetosDTO = new ArrayList<>();

                    for (ProjetoEntity projetoEntity : funcionario.getProjetos()) {
                        ShowProjetoDTO projetoDTO = new ShowProjetoDTO();
                        projetoDTO.setNome(projetoEntity.getNome());
                        projetoDTO.setDescricao(projetoEntity.getDescricao());
                        projetosDTO.add(projetoDTO);
                    }

                    departamentoDTO.setNome(funcionario.getDepartamento().getNome());
                    departamentoDTO.setGerente(funcionario.getDepartamento().getGerente());

                    funcionarioDTO.setId(funcionario.getId());
                    funcionarioDTO.setNome(funcionario.getNome());
                    funcionarioDTO.setEmail(funcionario.getEmail());
                    funcionarioDTO.setDepartamento(departamentoDTO);
                    funcionarioDTO.setProjetos(projetosDTO);

                    return funcionarioDTO;
                }).toList();
    }
}
