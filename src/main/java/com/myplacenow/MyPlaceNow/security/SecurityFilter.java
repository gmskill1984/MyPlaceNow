package com.myplacenow.MyPlaceNow.security;



import com.myplacenow.MyPlaceNow.model.UsuarioModel;
import com.myplacenow.MyPlaceNow.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    
    TokenService tokenService;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getServletPath();

        // Ignorar rotas públicas
        if (path.startsWith("/myplacenow/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            String token = recoverToken(request);

            if (token != null && !token.isBlank()) {
                String subject = tokenService.validarToken(token);
                if (subject != null) {
                    UsuarioModel usuario = usuarioRepository.findByEmailUsuario(subject);
                    if (usuario != null) {
                        UsuarioPrincipal usuarioP = new UsuarioPrincipal(usuario);
                        var authentication = new UsernamePasswordAuthenticationToken(
                                usuarioP, null, usuarioP.getAuthorities()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        }

        // Continua a cadeia de filtros normalmente
        filterChain.doFilter(request, response);
    }


    private String recoverToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.substring(7); 
    }
}