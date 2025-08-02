package com.myplacenow.MyPlaceNow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myplacenow.MyPlaceNow.model.UsuarioModel;
import com.myplacenow.MyPlaceNow.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<Object> save(UsuarioModel usuarioModel) {
        if (usuarioRepository.findByEmailUsuario(usuarioModel.getEmailUsuario()) != null) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");
        }

        usuarioModel.setSenhaUsuario(passwordEncoder.encode(usuarioModel.getSenhaUsuario()));
        usuarioRepository.save(usuarioModel);

        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarioRepository.findAll();
    }
}
