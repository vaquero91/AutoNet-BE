/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myTwitterAPI.autoNetBE;

import java.io.IOException;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import java.util.ArrayList;
import java.util.List;
import twitter4j.QueryResult;
/**
 *
 * @author juanh
 */
public class TwitterDriver {
    private final Twitter tw;
    private List<Status> statuses;
    private List<Tweet> tweets;
    
    public TwitterDriver(){
        tw = TwitterFactory.getSingleton();
        statuses = new ArrayList<>();
        tweets = new ArrayList<>();
    }
    public List<Tweet> returnTweets(){
        return tweets;
    }
    
    /** 
    * Funcion para traer todos los tweets de una persona, trae tambien retweets y replys
    * TODO: ajustar para que se traiga todos
    * @param user user tag del que quieres traer los tweets, NO agregar @
    */
    private void getTweets(String user) throws TwitterException, IOException{
        Paging page = new Paging(1,300);
        int p = 1;
        while( p <=23 ){
            page.setPage(p);
            statuses.addAll(tw.getUserTimeline(user, page));
            p++;
        }
    }
    
    /** 
    * Funcion que invoca getTweets , filtra los tweets y replys y guarda los resultafos en la lista tweets
    * regresa diferentes cantidades de tweets dependiendo de cuanto use tw el usuario
    * @param handle user tag del que quieres traer los tweets, NO agregar @
    */
    public void defaultQuery(String handle)throws TwitterException, IOException{
        statuses.clear();
        tweets.clear();
        getTweets(handle);
        int counter = statuses.size();
        int tweetsCounter = 0;
       
        for (int i = 0; i < counter; i++){
            if( !statuses.get(i).isRetweet()){  
                tweetsCounter ++;
                Tweet tweet = new Tweet(tweetsCounter, statuses.get(i).getText(), 
                        statuses.get(i).getCreatedAt().toString(), statuses.get(i).getRetweetCount(),
                        statuses.get(i).getFavoriteCount());
                tweets.add(tweet);
            } 
        }
    }

}
