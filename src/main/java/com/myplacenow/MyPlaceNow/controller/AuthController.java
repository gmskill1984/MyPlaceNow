package com.myplacenow.MyPlaceNow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.myplacenow.MyPlaceNow.dto.ResponseDTO;
import com.myplacenow.MyPlaceNow.model.UsuarioModel;
import com.myplacenow.MyPlaceNow.repository.UsuarioRepository;
import com.myplacenow.MyPlaceNow.security.TokenService;
import com.myplacenow.MyPlaceNow.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody; // ✅

@RestController
@RequestMapping("/myplacenow/api/v1/auth")
@CrossOrigin
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UsuarioService usuarioService, AuthenticationManager authenticationManager) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioModel usuarioModel) {
        var usuarioSenha = new UsernamePasswordAuthenticationToken(
                usuarioModel.getEmailUsuario(), 
                usuarioModel.getSenhaUsuario()
        );

        var auth = authenticationManager.authenticate(usuarioSenha);

        return ResponseEntity.ok("Login realizado com sucesso!"); // 
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> register(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.save(usuarioModel);
    }
}