package com.liquid.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liquid.demo.entities.DrinksEntity;

@Repository
public interface DrinksRepository extends JpaRepository<DrinksEntity, Long> {

}