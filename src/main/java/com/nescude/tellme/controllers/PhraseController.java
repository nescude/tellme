package com.nescude.tellme.controllers;

import com.nescude.tellme.model.Phrase;
import com.nescude.tellme.model.PhraseBuilder;
import com.nescude.tellme.services.PhraseService;
import com.nescude.tellme.templates.outputs.PhraseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p")
public class PhraseController {

    @Autowired
    PhraseService service;

    @GetMapping("/{uniqueName}")
    private PhraseResponse getPhrase(@PathVariable String uniqueName){
        return service.getPhrase(uniqueName);
    }

    @PostMapping("")
    public PhraseResponse postPhrase(@RequestBody Phrase phrase){
        return service.postPhrase(PhraseBuilder.Builder()
        .content(phrase.getContent())
        .uniqueName(phrase.getUniqueName())
        .build());
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong!";
    }

    @GetMapping({"/",""})
    public Iterable<PhraseResponse> getAll(){
        return service.getAll();
    }

}
