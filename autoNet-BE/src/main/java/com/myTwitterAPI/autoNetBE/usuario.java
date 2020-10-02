/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author juanh
 */

@Entity
@Table(name="usuario")
public class usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String email;
    String password;
    String token;
    String nombre;
    
    public usuario(){}
    
    public usuario( String email, String password, String nombre){
        this.email = email;
        this.password = password;
        this.nombre = nombre;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
}
