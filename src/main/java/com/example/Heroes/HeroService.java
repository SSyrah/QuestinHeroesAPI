package com.example.Heroes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HeroService {
    private ArrayList<String> heroes;

    public HeroService(){
        System.out.println("Creating heroService");
        this.heroes = new ArrayList<>();
        heroes.add("Thor");
        heroes.add("Loki");
        heroes.add("Ironman");
        heroes.add("Captain America");
    }
    public ArrayList<String> getHeroes() {
        return heroes;
    }

    public void setHeroes(String hero) {
        heroes.add(hero);
    }
}
