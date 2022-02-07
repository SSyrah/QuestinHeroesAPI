package com.example.Heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class QuestService {
    private ArrayList<Quest> quests;

    @Autowired
    private HeroService heroService;

    public QuestService() {
        System.out.println("Creating quests...");
        this.quests = new ArrayList<>();
        this.quests.add(new Quest("Steal somethings valuable", 12));
        this.quests.add(new Quest("Beat biggest opponent", 18));
        this.quests.add(new Quest("Last Fight", 19));

    }

    public ArrayList<Quest> getQuests(){
        return this.quests;
    }

    public void addQuest(String name, int difficulty){
        this.quests.add(new Quest(name, difficulty));
    }

    public Quest findQuestByName(String questName) {
        for (Quest quest : quests) {
            if (quest.getName().equals(questName)) {
                return quest;
            }
        }
        return null;
    }

    public void deleteQuestByName(String name){
        Quest quest = findQuestByName(name);
        this.quests.remove(quest);
    }

    public void tryQuest(String heroName, String questName) {
        Hero hero = heroService.findHeroByName(heroName);
        Quest quest = findQuestByName(questName);
        for (int i = 0; i < hero.getLevel(); i++) {
            int x = (int) (Math.random() * 20) + 1;
            if (x > quest.getDifficulty()) {
                hero.completeQuest();
                return;
            }
        }
        hero.failQuest();
    }



}
