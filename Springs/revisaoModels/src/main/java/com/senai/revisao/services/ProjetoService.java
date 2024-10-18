package com.senai.revisao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.revisao.dtos.req.ChangeProjetoDTO;
import com.senai.revisao.entities.ProjetoEntity;
import com.senai.revisao.repositories.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

    @Transactional
    public void changeProjetoByName(String name, ChangeProjetoDTO dto) {

        Optional<ProjetoEntity> optionalProjetoEntity = projetoRepository.findByNome(name);

        if (optionalProjetoEntity.isEmpty()) {
            // jogar uma excecao
        }

        ProjetoEntity projetoEntity = optionalProjetoEntity.get();

        projetoEntity.setNome(dto.getNome());
        projetoEntity.setDescricao(dto.getDescricao());

        projetoRepository.save(projetoEntity);
    }

}
