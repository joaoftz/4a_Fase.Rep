package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recuperacaoprova.entities.AdotantesEntity;

@Repository
public interface AdotantesRepository extends JpaRepository<AdotantesEntity, Long> {

    

    
}
