package com.myplacenow.MyPlaceNow.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.myplacenow.MyPlaceNow.model.UsuarioModel;

@Service
public class TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);
    private static final String ISSUER = "login-auth-api";

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(UsuarioModel usuarioModel) {
        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(usuarioModel.getEmailUsuario())
                    .withIssuedAt(Instant.now())
                    .withExpiresAt(gerarExpirationDate())
                    .sign(getAlgorithm());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    public String validarToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            return null;
        }

        try {
            return JWT.require(getAlgorithm())
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            logger.warn("Token JWT inválido: {}", e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Erro inesperado ao validar token: {}", e.getMessage(), e);
            return null;
        }
    }

    private Instant gerarExpirationDate() {
        return LocalDateTime.now()
                .plusHours(1)
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .toInstant();
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret);
    }
}
