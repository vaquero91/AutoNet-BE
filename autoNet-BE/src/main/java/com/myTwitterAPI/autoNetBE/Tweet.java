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
public class Tweet {
    private int id;
    private String cuerpo;
    private String fecha;
    private int RtCount;
    private int FavCount;
    
    public Tweet(int id,String cuerpo, String fecha, int RtCount, int FavCount){
        this.id = id;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.RtCount = RtCount;
        this.FavCount = FavCount;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setCuerpo(String cuerpo){
        this.cuerpo = cuerpo;
    }
    
    public String getCuerpo(){
        return this.cuerpo;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public String getFecha(){
        return this.fecha;
    }
    
    public void setRtCount(int rt){
        this.RtCount = rt;
    }
    
    public int getRtCount(){
        return this.RtCount;
    }
     public void setFavCount(int rt){
        this.FavCount= rt;
    }
    
    public int getFavCount(){
        return this.FavCount;
    }
}
