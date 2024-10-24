package com.example.liquidsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.liquidsa.entities.CurtidaEntity;

@Repository
public interface CurtidaRepository extends JpaRepository<CurtidaEntity, Long> {

    

    
}
