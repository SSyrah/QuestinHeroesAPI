package com.example.Heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HeroController {

    @Autowired
    private HeroService heroService;
    @Autowired
    private QuestService questService;

    @GetMapping("/heroes")
    public String getHeroes(Model model){
        ArrayList<Hero> heroes = heroService.getHeroes();
        model.addAttribute("heroes", heroes);
        return "heroes";
    }
    @PostMapping("/heroes")
    public String addHero(@RequestParam String heroName){
        heroService.setHeroes(heroName);
        return "redirect:/heroes";
    }

    @GetMapping("heroes/{heroName}")
    public String getHeroInfo(@PathVariable String heroName, Model model){
        Hero hero = heroService.findHeroByName(heroName);
        ArrayList<Quest> quests = questService.getQuests();
        // add hero to model, then return it
        model.addAttribute("hero", hero);
        model.addAttribute("quests",quests);
        return "hero";
    }
}
