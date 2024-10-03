package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recuperacaoprova.entities.HistoricoEntity;

public interface HistoricoRepository extends JpaRepository<HistoricoEntity, Long>{
    
}
