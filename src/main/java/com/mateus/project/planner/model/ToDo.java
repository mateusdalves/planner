package com.mateus.project.planner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;
import java.util.UUID;

public class ToDo {
    private final String description;
    private final String name;
    private Boolean done;
    private String state;
    private final UUID id;

    public ToDo(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description){
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = false;
        this.state = "created";
    }

    public void complete() {
        this.done = true;
        this.state = "completed";
    }

    public String getDescription(){
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public UUID getId(){
        return this.id;
    }
}
