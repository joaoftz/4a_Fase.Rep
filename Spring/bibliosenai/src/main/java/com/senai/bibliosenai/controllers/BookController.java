package com.senai.bibliosenai.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.bibliosenai.dtos.request.CreateBookDto;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/books")
public class BookController {

    // /books
    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody CreateBookDto dto){

       System.out.println(dto.getAuthor()); 
       System.out.println(dto.getTitle());
       System.out.println(dto.getDescription());
       

        return ResponseEntity.status(201).build();
    } 
}
