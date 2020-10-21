/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juanh
 */
@RestController
public class testRest {
    
     @GetMapping("/")
        public String index() {
            return "Hello Spring Boot!";
        }
}
