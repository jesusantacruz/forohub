package com.aluracursos.forohub.controllers;

import com.aluracursos.forohub.domain.users.User;
import com.aluracursos.forohub.domain.users.UserAuthData;
import com.aluracursos.forohub.security.TokenJWTData;
import com.aluracursos.forohub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")

public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJWTData> autenticarUsuario(@RequestBody @Valid UserAuthData userAuthData) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthData.username(),
                userAuthData.pass());
        var authUser = authenticationManager.authenticate(authToken);
        var jwtTtoken = tokenService.makeToken((User) authUser);
        return ResponseEntity.ok(new TokenJWTData(jwtTtoken));
    }

}