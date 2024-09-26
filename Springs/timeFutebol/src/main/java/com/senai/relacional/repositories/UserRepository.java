package com.senai.relacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.relacional.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
