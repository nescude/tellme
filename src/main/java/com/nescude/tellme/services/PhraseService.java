package com.nescude.tellme.services;

import java.util.ArrayList;

import com.nescude.tellme.model.Phrase;
import com.nescude.tellme.repositories.IPhraseRepo;
import com.nescude.tellme.templates.outputs.PhraseResponse;
import com.nescude.tellme.utils.FormatCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhraseService {

    @Autowired
    IPhraseRepo repo;

    public PhraseResponse getPhrase(String uniqueName){
        return new PhraseResponse(repo.findByUniqueName(uniqueName));
    }

    public PhraseResponse postPhrase(Phrase phrase){
        phrase.setUniqueName(phrase.getUniqueName().trim());
        if (phrase.getUniqueName().length() > 20){
            phrase.setContent("Error, 'uniqueName' muy largo");
            return new PhraseResponse(phrase);
        }
        if (repo.existsByUniqueName(phrase.getUniqueName())){
            phrase.setContent("Error, 'uniqueName' existente!");
            return new PhraseResponse(phrase);
        }
        if (FormatCheck.check(phrase.getContent(), phrase.getUniqueName()))
        {
            phrase.setContent("Error, no se admiten links!");
            return new PhraseResponse(phrase);
        }
        return new PhraseResponse(repo.save(phrase));
    }

    public Iterable<PhraseResponse> getAll(){
        ArrayList<PhraseResponse> list = new ArrayList<>();
        repo.findAll().forEach(phrase -> {
            list.add(new PhraseResponse(phrase));
        });
        return list;
    }
    
}
