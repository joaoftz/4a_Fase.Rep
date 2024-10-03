package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recuperacaoprova.entities.AnimaisEntity;

@Repository
public interface AnimaisRepository extends JpaRepository<AnimaisEntity, Long>{

    
    
}
