/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

/**
 *
 * @author juanh
 */
public class Cuenta {
    String username;
    String red;
    int followers;
    int following;
    
    public Cuenta(){}
    
    public Cuenta(String username, String red){
        this.username = username;
        this.red = red;
    }
    
    public void setFollowers(int followers){
        this.followers = followers;
    }
    public int getFollowing(){
        return this.followers;
    }
    public void setFollowing(int following){
        this.following = following;
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
}
