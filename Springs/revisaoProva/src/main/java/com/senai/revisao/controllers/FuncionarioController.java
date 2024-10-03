package com.senai.revisao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.revisao.dtos.req.CreateFuncionarioDTO;
import com.senai.revisao.dtos.res.ShowFuncionarioDTO;
import com.senai.revisao.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<?> createFuncionario(@RequestBody CreateFuncionarioDTO dto) {

        System.out.println(dto.getNome());
        System.out.println(dto.getDepartamento().getNome());
        System.out.println(dto.getProjetos().get(0).getNome());

        funcionarioService.createFuncionario(dto);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllFuncionarios() {

        List<ShowFuncionarioDTO> funcionarios = funcionarioService.getAllFuncionarios();

        return ResponseEntity.status(200).body(funcionarios);
    }

}
