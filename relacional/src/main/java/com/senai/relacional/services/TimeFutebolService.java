package com.senai.relacional.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.relacional.entities.TimeFutebolEntity;
import com.senai.relacional.repositories.TimeFutebolRepository;

@Service
public class TimeFutebolService {

    @Autowired
    TimeFutebolRepository timeFutebolRepository;

    public List<TimeFutebolEntity> getAllTimes() {

        return timeFutebolRepository.findAll();
     }

    public Object findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
