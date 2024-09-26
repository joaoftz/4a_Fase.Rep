package senai.example.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.example.prova.entities.AdotantesEntity;

public interface AdotantesRepository extends JpaRepository<AdotantesEntity, Long> {

}