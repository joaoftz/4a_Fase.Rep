package senai.example.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.example.prova.entities.AnimaisEntity;

public interface AnimaisRepository extends JpaRepository<AnimaisEntity, Long>{

 }

