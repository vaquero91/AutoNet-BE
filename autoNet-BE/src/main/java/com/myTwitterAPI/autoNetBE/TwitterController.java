/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.TwitterException;
/**
 *
 * @author juanh
 */
@Controller
@RestController
public class TwitterController {
    TwitterDriver tw = new TwitterDriver();
    
    
    @GetMapping("/defaultQuery")
    public List<Tweet> defaultQuery(@RequestParam String usuario) throws TwitterException, IOException{
        
        tw.defaultQuery(usuario);
        return tw.returnTweets();
    }
    
    @GetMapping("/testTw")
    public String testTw(){
        return "Twitter esta presente";
    }
}
