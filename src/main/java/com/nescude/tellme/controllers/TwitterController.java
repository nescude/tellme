package com.nescude.tellme.controllers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.LinkedHashMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.nescude.tellme.services.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wh/tw/")
public class TwitterController {
    @Autowired
    TwitterService service;

    @GetMapping("/{tweetId}")
    private LinkedHashMap<String,String> getTweet(@PathVariable String tweetId){
        return service.getTweetById(Integer.valueOf(tweetId));
    }

    @PostMapping({"/",""})
    @ResponseStatus(HttpStatus.OK)
    public boolean post(){
        return true;
    }

    @GetMapping({"/",""})
    @ResponseStatus(HttpStatus.OK)
    public LinkedHashMap getAll(@RequestParam String crc_token){
        LinkedHashMap hm = new LinkedHashMap<>();
        try {
            System.out.println(crc_token);
            Mac m = Mac.getInstance("HmacSHA256");
            m.init(new SecretKeySpec(TwitterService.API_SECRET.getBytes(), "HmacSHA256"));
            m.update(crc_token.getBytes());
            String encoded = Base64.getEncoder().encodeToString(m.doFinal());
            hm.put("response_token", "sha256="+encoded);
            return hm;
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        hm.put("response_token", crc_token);
        return hm;
    }
}
