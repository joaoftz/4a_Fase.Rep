package com.senai.revisao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.revisao.entities.ProjetoEntity;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {

}
