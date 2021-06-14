package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RadioProgram {
    private final int id;
    private final String name;
    private final String description;

    @JsonCreator
    public RadioProgram(
      @JsonProperty("program:id") int id,
      @JsonProperty("program:name") String name,
      @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
}

