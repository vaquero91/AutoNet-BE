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
    public usuario newUser(@RequestBody usuario body){
        String token = getJWTToken(body.getEmail());
        usuarioRepositorio.save(body);
        body.setPassword("");
        body.setToken(token);
        
        return body;
    }
    @GetMapping("/getUsuario")
    public List<usuario> getUser(){
        List<usuario> usuario = new ArrayList<>();
        usuarioRepositorio.findAll().forEach(usuario::add);
        return usuario;
    }
    
    @PostMapping("/login")
    public usuario login(@RequestBody usuario body){
        String token = getJWTToken(body.getEmail());
        usuario us = new usuario();
        
        if(findMyUser(body.getEmail(), body.getPassword())){
            usuario val = getMyUsuario(body.email);
            us.setToken(token);
            us.setNombre(val.nombre);
            us.setId(val.id);
        }
        return us;

    }
    
    @GetMapping("/testAuth")
    public String testAuth(){
        return "You have access";
    }
    
    private boolean findMyUser(String email, String password){
        List<usuario> usuarioList = new ArrayList<>();
        usuarioRepositorio.findAll().forEach(usuarioList::add);
        boolean result = false;
        for(usuario us: usuarioList){
            if(us.getEmail().equals(email) && us.getPassword().equals(password)){
                result = true;
            }
        }
        return result;
    }
    
    private usuario getMyUsuario(String email){
        return usuarioRepositorio.findByEmail(email);
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
