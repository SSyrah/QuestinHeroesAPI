package com.example.Heroes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data       // lombok - dependency, adds getters and setters
@AllArgsConstructor         // creates all-args-constructor
// @NoArgsConstructor // adds constructor with arguments open
public class Hero {
    private String name;
    private String status;
    private int level;
    private int health;
    private int gold;
    private int stamina;

    public Hero(String name) {
        this.name = name;
        this.status ="This is noob guy";
        this.level = 1;
        this.health = 1;
        this.gold = 1;
    }




}
