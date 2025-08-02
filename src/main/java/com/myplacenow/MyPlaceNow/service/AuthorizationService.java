package com.myplacenow.MyPlaceNow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.myplacenow.MyPlaceNow.model.UsuarioModel;
import com.myplacenow.MyPlaceNow.repository.UsuarioRepository;
import com.myplacenow.MyPlaceNow.security.UsuarioPrincipal;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AuthorizationService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioRepository.findByEmailUsuario(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email);
        }

        // Retorna um objeto UserDetails (adaptado com a classe UsuarioPrincipal)
        return new UsuarioPrincipal(usuario);
    }
}
