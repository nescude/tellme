package com.nescude.tellme.repositories;

import com.nescude.tellme.model.Phrase;
import org.springframework.data.mongodb.repository.MongoRepository;

@SuppressWarnings("unchecked")
public interface IPhraseRepo extends MongoRepository<Phrase,String> {
    
    public Phrase save(Phrase phrase);
    public Phrase findByUniqueName(String uniqueName);
    public Boolean existsByUniqueName(String uniqueName);

}
