package com.example.Heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HeroService {
    // private ArrayList<Hero> heroes;

    @Autowired
    private HeroRepository heroRepository;

    /*
    public HeroService(){
        System.out.println("Creating heroService");
        this.heroes = new ArrayList<>();
        Hero h1 = new Hero("Thor", "Relaxing...", 10, 20, 2000, 88);
        heroes.add(h1);
        heroes.add(new Hero("Loki", "Chilling", 8 ,10, 200, 55));
        heroes.add(new Hero("Ironman", "Panicing", 14 ,16, 1600, 88));
        heroes.add(new Hero("Captain America", "Feeling good", 15 ,20, 890, 100));
    }*/

    public ArrayList<Hero> getHeroes() {
        return this.heroRepository.findAll();
        //return this.heroes;
    }

    public void setHeroes(String hero) {
        this.heroRepository.save(new Hero(hero));
        // this.heroes.add(new Hero(hero));
    }

    public Hero findHeroByName(String heroName){
        return this.heroRepository.findByName(heroName).get(0);

        /*for(Hero hero : heroes){
            if (hero.getName() .equals(heroName)){
                return hero;
            }
        }
        return heroes.get(0);*/
    }
}
