package com.example.Heroes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Data       // lombok - dependency, adds getters and setters
@AllArgsConstructor         // creates all-args-constructor
@NoArgsConstructor // adds constructor with arguments open

public class Hero extends AbstractPersistable<Long> {
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

    public void completeQuest(){
        this.gold+= 100;
        this.level+= 1;
        this.status = "Completed Quest!!!";
    }

    public void failQuest(){
        this.gold = 0;
        this.health -= 1;

        if (this.health == 0){this.status = "Oh no, hero DIED!";}
        else {this.status = "Failed in the quest..sorry";}
    }




}
