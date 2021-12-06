package com.nescude.tellme.templates.outputs;

import com.nescude.tellme.model.Phrase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PhraseResponse {
    private String uniqueName, content;

    public PhraseResponse(Phrase phrase){
        this.content = phrase.getContent();
        this.uniqueName = phrase.getUniqueName();
    }
}
