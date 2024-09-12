package com.senai.bibliosenai.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class BibliotecaController {
    
    @GetMapping("/biblioteca")
    public String findBiblioteca(){
        return "Teste";
    }

    @PostMapping("/livros")
    public String createBiblioteca(){
        return "Criado";
    }

    @DeleteMapping("/livros/{id}")
    public String deleteLivros(@PathVariable int id){
        return "Deletado";
    }

    @PatchMapping("/livros{id}")
    public String alteraCodigoLivro(@PathVariable int id){
        return "Código do livro alterado!";
    }

    @PutMapping("/livros{id}")
    public String alteraObjetoLivro(@PathVariable int id){
        return "Todos os campos alterados";
    }
}
