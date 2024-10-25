package com.example.liquidsa.services;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.liquidsa.dtos.req.CreateUsuarioDTO;
import com.example.liquidsa.dtos.res.ShowUsuarioDTO;
import com.example.liquidsa.entities.UsuarioEntity;
import com.example.liquidsa.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ShowUsuarioDTO criarUsuario(CreateUsuarioDTO CreateUsuarioDTO) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(CreateUsuarioDTO.getNome());
        usuario.setEmail(CreateUsuarioDTO.getEmail());
        usuario.setSenha(CreateUsuarioDTO.getSenha());
        usuario.setBio(CreateUsuarioDTO.getBio());

        usuario = usuarioRepository.save(usuario);

        ShowUsuarioDTO response = new ShowUsuarioDTO();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setBio(usuario.getBio());

        return response;
    }

    public List<ShowUsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> {
            ShowUsuarioDTO response = new ShowUsuarioDTO();
            response.setId(usuario.getId());
            response.setNome(usuario.getNome());
            response.setEmail(usuario.getEmail());
            response.setBio(usuario.getBio());
            return response;
        }).collect(Collectors.toList());
    }

    public ShowUsuarioDTO buscarUsuarioPorId(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        ShowUsuarioDTO response = new ShowUsuarioDTO();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setBio(usuario.getBio());

        return response;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
