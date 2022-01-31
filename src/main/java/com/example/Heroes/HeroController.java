package com.example.Heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/heroes")
    public String getHeroes(Model model){
        ArrayList<String> heroes = heroService.getHeroes();
        model.addAttribute("heroes", heroes);
        return "heroes";
    }
    @PostMapping("/heroes")
    public String addHero(@RequestParam String heroName){
        heroService.setHeroes(heroName);
        return "heroes";
    }
}
