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
@Table(name="cuentas")
public class Cuenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    String username;
    int usuario;
    String red;
    
    public Cuenta(){}
    
    public Cuenta(String username, String red, int usuarioNum) {
        this.usuario = usuarioNum;
        this.username = username;
        this.red = red;
    }
    
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }  
    public String getRed(){
        return this.red;
    }
    public void setRed(String red){
        this.red = red;
    }
    
    public void setIdUsuario(int usuario){
        this.usuario = usuario;
    }
    public int getIdUsuario(){
        return this.usuario;
    }
}
