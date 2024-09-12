package com.liquid.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.demo.dtos.request.CreateDrink;
import com.liquid.demo.services.DrinksService;

@RestController
@RequestMapping("/liquid")
public class DrinksController {
    @Autowired
    DrinksService drinksService;

    @GetMapping("/drinks-liquid")
    public ResponseEntity<?> getDrinks() {
        var drinks = drinksService.getAllDrinks();

        return ResponseEntity.ok(drinks);
    }

    // @PostMapping("/drinks-liquid-post")
    // public ResponseEntity<?> postMethodName(@RequestBody CreateDrink dto){
       
        

    //     return ResponseEntity.ok(dto);
    // } 

    
    @PostMapping("/drinks-liquid-post")
    public ResponseEntity<?> postUserFutAgenda(@RequestBody CreateDrink dto){
        drinksService.createDrink(dto);
        
        return ResponseEntity.ok(dto);


    }
}
