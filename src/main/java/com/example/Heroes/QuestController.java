package com.example.Heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestController {

    @Autowired
    private QuestService questService;

    @GetMapping("/quests")
    public String getQuests(Model model){
        List<Quest> quests = questService.getQuests();
        model.addAttribute("quests", quests);
        return "quests";
    }

    @PostMapping("/quests")
    public String addQuest(@RequestParam String questName, int questDifficulty){
        questService.addQuest(questName, questDifficulty);
        return "redirect:/quests";
    }

    @PostMapping("/deletequest")
    public String deleteQuest(@RequestParam String questName){
        questService.deleteQuestByName(questName);
        return "redirect:/quests";
    }

    @PostMapping("/tryquest")
    public String tryQuest(@RequestParam String heroName, String questName){
        questService.tryQuest(heroName, questName);
        return "redirect:/heroes/" + heroName;
    }


}
