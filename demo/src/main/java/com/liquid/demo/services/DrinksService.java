package com.liquid.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.demo.dtos.request.CreateDrink;
import com.liquid.demo.entities.DrinksEntity;
import com.liquid.demo.repositories.DrinksRepository;

@Service
public class DrinksService {

    @Autowired
    DrinksRepository drinksRepository;

    public List<DrinksEntity> getAllDrinks() {
        
        return  drinksRepository.findAll();
    }

    public void createDrink(CreateDrink dto) {
        DrinksEntity entity = new DrinksEntity();
        entity.setNomeDrink(dto.getNomeDrink());
        entity.setValor(dto.getValor());
        entity.setAlcoolico(dto.getAlcoolico());
        drinksRepository.save(entity);
    }

    
    
}
