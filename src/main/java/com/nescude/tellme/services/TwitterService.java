package com.nescude.tellme.services;

import java.util.LinkedHashMap;

import com.nescude.tellme.utils.JSONReader;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterService{

    public static String API_KEY, API_SECRET, TOKEN_BEARER,ACCESS_TOKEN,TOKEN_SECRET;
    private final String GET_END = "https://api.twitter.com/2/tweets/";

    @Autowired
    RestTemplate rt;

    static{
        JSONObject ob =  JSONReader.read(
            TwitterService.class.getResource("/credentials.json").getFile()
        );
        if (ob!=null){
            API_KEY = ob.getString("consumer_key");
            API_SECRET = ob.getString("consumer_secret");
            TOKEN_BEARER = ob.getString("bearer_token");
            ACCESS_TOKEN = ob.getString("access_token");
            TOKEN_SECRET = ob.getString("token_secret");
        }
    }

    public void show(){
        System.out.println("--> "+API_KEY+" -> "+API_SECRET+" -> "+TOKEN_BEARER);
    }

    public LinkedHashMap<String,String> getTweetById(Integer tweetId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "BEARER "+TOKEN_BEARER);
        HttpEntity<Object> request = new HttpEntity<Object>(null,headers);
        ResponseEntity<Object> result = rt.exchange(GET_END+tweetId, HttpMethod.GET, request, Object.class);
        LinkedHashMap<String,String> map = (LinkedHashMap)((LinkedHashMap)result.getBody()).get("data");
        return map;
    }
    
    
}
