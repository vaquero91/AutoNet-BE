/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author juanh
 */
public interface CuentaRepositorio  extends  CrudRepository<Cuenta, Integer>{
    List<Cuenta> findByUsuario(int usuario);
}
