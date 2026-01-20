package com.forum_hub.controller;

import com.forum_hub.domain.usuario.Usuario;
import com.forum_hub.infra.security.DadosAutenticacao;
import com.forum_hub.infra.security.DadosTokenJWT;
import com.forum_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> autenticar(
            @RequestBody @Valid DadosAutenticacao dados
    ) {

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        dados.login(),
                        dados.senha()
                );

        var authentication = manager.authenticate(authenticationToken);

        var usuario = (Usuario) authentication.getPrincipal();

        var tokenJWT = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
