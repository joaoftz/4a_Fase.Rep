package com.senai.relacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.relacional.entities.TimeFutebolEntity;

@Repository
public interface TimeFutebolRepository extends JpaRepository<TimeFutebolEntity, Long> {
    
}
