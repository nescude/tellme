package com.nescude.tellme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Document("Phrases")
public class Phrase {

    @Id
    protected String id;
    protected String uniqueName;
    protected String content;
    
}
