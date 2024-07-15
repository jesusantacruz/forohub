package com.aluracursos.forohub.controllers;

import com.aluracursos.forohub.domain.users.User;
import com.aluracursos.forohub.domain.users.UserAuthData;
import com.aluracursos.forohub.security.TokenJWTData;
import com.aluracursos.forohub.security.TokenService;
import jakarta.transaction.Transactional;
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

    @Transactional
    @PostMapping
    public ResponseEntity<TokenJWTData> authUser(@RequestBody @Valid UserAuthData userAuthData) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthData.username(),
                userAuthData.pass());
        var authUser = authenticationManager.authenticate(authToken);
        System.out.println(authUser);
        var jwtTtoken = tokenService.makeToken((User) authUser.getPrincipal());
        return ResponseEntity.ok(new TokenJWTData(jwtTtoken));
    }

}