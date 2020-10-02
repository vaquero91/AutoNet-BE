/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author juanh
 */
@Controller
@RestController
public class usuarioController {
    @Autowired
    private usuarioRepositorio usuarioRepositorio;
    
    @PostMapping("/nuevoUsuario")
    public String newUser(@RequestBody usuario body){
        usuarioRepositorio.save(body);

        return "Success";
    }
    @GetMapping("/getUsuario")
    public List<usuario> getUser(){
        
         List<usuario> usuario = new ArrayList<>();
         usuarioRepositorio.findAll().forEach(usuario::add);
         return usuario;
    }

    private String getJWTToken(String username) {
            String secretKey = "mySecretKey";
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                            .commaSeparatedStringToAuthorityList("ROLE_USER");

            String token = Jwts
                            .builder()
                            .setId("softtekJWT")
                            .setSubject(username)
                            .claim("authorities",
                                            grantedAuthorities.stream()
                                                            .map(GrantedAuthority::getAuthority)
                                                            .collect(Collectors.toList()))
                            .setIssuedAt(new Date(System.currentTimeMillis()))
                            .setExpiration(new Date(System.currentTimeMillis() + 600000))
                            .signWith(SignatureAlgorithm.HS512,
                                            secretKey.getBytes()).compact();

            return "Bearer " + token;
    }
}
