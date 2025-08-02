package com.myplacenow.MyPlaceNow.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myplacenow.MyPlaceNow.enums.UsuarioRoles;
import com.myplacenow.MyPlaceNow.model.UsuarioModel;

public class UsuarioPrincipal implements UserDetails {
   
	private final UsuarioModel usuario;

    public UsuarioPrincipal(UsuarioModel usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (usuario.getUsuarioRoles() == UsuarioRoles.ADMIN) {
            return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USUARIO")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
        }
    }

    @Override
    public String getPassword() {
        return usuario.getSenhaUsuario();
    }

    @Override
    public String getUsername() {
        return usuario.getEmailUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "S".equalsIgnoreCase(usuario.getAtivoUsuario());
    }

    // Você pode adicionar um getter para pegar o usuário original, se precisar
    public UsuarioModel getUsuario() {
        return usuario;
    }
}
