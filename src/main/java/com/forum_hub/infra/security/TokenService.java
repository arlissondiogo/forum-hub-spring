package com.forum_hub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.forum_hub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("forum-hub")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar token JWT", e);
        }
    }

    public String getSubject(String tokenJWT) {
        var algoritmo = Algorithm.HMAC256(secret);
        return JWT.require(algoritmo)
                .withIssuer("forum-hub")
                .build()
                .verify(tokenJWT)
                .getSubject();
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now()
                .plusHours(expiration)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
