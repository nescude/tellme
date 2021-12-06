package com.nescude.tellme.model;

public class PhraseBuilder extends Phrase{

    public static PhraseBuilder Builder(){
        return new PhraseBuilder();
    }

    public PhraseBuilder content(String content){
        setContent(content);
        return this;
    }

    public PhraseBuilder uniqueName(String uniqueName){
        setUniqueName(uniqueName);
        return this; 
    }

    public Phrase build(){
        return (Phrase) this;
    }
    
}
