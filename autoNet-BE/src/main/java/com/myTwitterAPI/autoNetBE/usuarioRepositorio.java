/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juanh
 */
@Repository
public interface usuarioRepositorio extends  CrudRepository<usuario, Integer> {
    usuario findByEmail(String email);
}
