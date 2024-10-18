package com.senai.revisao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.revisao.dtos.req.ChangeFuncionarioDTO;
import com.senai.revisao.dtos.req.CreateFuncionarioDTO;
import com.senai.revisao.dtos.res.ShowDepartamentoDTO;
import com.senai.revisao.dtos.res.ShowFuncionarioDTO;
import com.senai.revisao.dtos.res.ShowProjetoDTO;
import com.senai.revisao.models.Funcionario;
import com.senai.revisao.models.Projeto;
import com.senai.revisao.services.FuncionarioService;
import com.senai.revisao.services.ProjetoService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ProjetoService projetoService;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllFuncionarios(@PathVariable long id) {

        System.out.println(id);
        Funcionario funcionario = funcionarioService.getFuncionarioById(id);

        ShowFuncionarioDTO dto = new ShowFuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setEmail(funcionario.getEmail());
        dto.setNome(funcionario.getNome());

        ShowDepartamentoDTO departamentoDto = new ShowDepartamentoDTO();
        departamentoDto.setNome(funcionario.getDepartamento().getNome());
        departamentoDto.setGerente(funcionario.getDepartamento().getGerente());

        for (Projeto projeto : funcionario.getProjetos()) {
            ShowProjetoDTO projetoDTO = new ShowProjetoDTO();

            projetoDTO.setNome(projeto.getNome());
            projetoDTO.setDescricao(projeto.getDescricao());
            projetoDTO.setRenda(projeto.calcularRendaMes(20, 1200f));

            dto.setProjeto(projetoDTO);        
        }

        dto.setDepartamento(departamentoDto);
        
        return ResponseEntity.status(200).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable long id) {

        funcionarioService.deleteFuncionarioById(id);

        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> changeFuncionario(@PathVariable long id, @RequestBody ChangeFuncionarioDTO dto) {

        funcionarioService.changeFuncionarioInfosById(id, dto);

        return ResponseEntity.status(200).build();
    }

    // @PutMapping("/{idFuncionario}/projetos/{nomeProjeto}")
    // public ResponseEntity<?> putMethodName(@PathVariable long idFuncionario,
    // @PathVariable String nomeProjeto,
    // @RequestBody ChangeProjetoDTO changeProjetoDTO) {

    // ShowFuncionarioDTO funcDTO =
    // funcionarioService.getFuncionarioById(idFuncionario);

    // for (ShowProjetoDTO projetoDTO : funcDTO.getProjetos()) {
    // if (projetoDTO.getNome().equals(nomeProjeto)) {
    // projetoService.changeProjetoByName(nomeProjeto, changeProjetoDTO);
    // }
    // }

    // return ResponseEntity.status(200).build();
    // }
}
