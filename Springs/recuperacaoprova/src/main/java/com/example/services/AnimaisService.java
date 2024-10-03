package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recuperacaoprova.dtos.req.CreateAnimaisDTO;
import com.example.recuperacaoprova.entities.AnimaisEntity;
import com.example.recuperacaoprova.entities.HistoricoEntity;
import com.example.repositories.AdotantesRepository;
import com.example.repositories.AnimaisRepository;
import com.example.repositories.HistoricoRepository;

@Service
public class AnimaisService {

    @Autowired
    AnimaisRepository animaisRepository;

    @Autowired
    HistoricoRepository historicoRepository;

    @Autowired
    @AdotantesRepository AdotantesRepository;

    public void createAnimais(CreateAnimaisDTO dto) {

        AnimaisEntity animaisEntity = new AnimaisEntity();
        animaisEntity.setNome(dto.getNome());
        animaisEntity.setTipo(dto.getTipo());

        animaisEntity = animaisRepository.save(animaisEntity);

        var historicoEntity = new HistoricoEntity();
        historicoEntity.setDataAdocao(dto.getHistorico().getDataAdocao());
        historicoEntity.setAdotantes(adotantesEntity);


    }

    
}
