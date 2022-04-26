package dev.sud.digitalwallet.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private String id;
    private String name;

    public User(String name){
        this.id= UUID.randomUUID().toString();
        this.name=name;
    }
}
