package com.example.consumerApi2.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Setter
@Getter
public class Location {

    private String code, name, description;
    private Coordinates coordinates;
    private Location parent;
    private Set<Location> children;

    public Location(){
    }

     public Location(String code,String name,String description){
        this.code=code;
        this.name=name;
        this.description=description;
    }
}
