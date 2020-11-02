/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanh
 */
@Controller
@RestController
public class CuentaControllet {
    @Autowired
    private CuentaRepositorio cuentaRepositorio;
    
    @GetMapping("/getCuentas")
    public List<Cuenta> getCuentas(){
        List<Cuenta> cuentas = new ArrayList<>();
        cuentaRepositorio.findAll().forEach(cuentas::add);
        return cuentas;
    }
    
    @PostMapping("/nuevaCuenta")
    public String nuevaCuenta(@RequestBody Cuenta body){
        cuentaRepositorio.save(body);
        return "Exito";
    }
    @GetMapping("/CuentasUsuario")
    public List<Cuenta> getCuentasDeUsuario(@RequestParam int usuario){
        return cuentaRepositorio.findByUsuario(usuario);
    }
    
            
}
