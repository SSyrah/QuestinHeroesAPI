package com.example.Heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestService {
    // private ArrayList<Quest> quests;

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private HeroService heroService;

    /*public QuestService() {
        System.out.println("Creating quests...");
        this.quests = new ArrayList<>();
        this.quests.add(new Quest("Steal somethings valuable", 12));
        this.quests.add(new Quest("Beat biggest opponent", 18));
        this.quests.add(new Quest("Last Fight", 19));

    }*/

    public List<Quest> getQuests(){
        // return all quests which exist
        return this.questRepository.findAll();
        //return this.quests;
    }

    public void addQuest(String name, int difficulty){
        // add new Quest to database
        this.questRepository.save(new Quest(name, difficulty));
        //this.quests.add(new Quest(name, difficulty));
    }

    public Quest findQuestByName(String questName) {
        return this.questRepository.findByName(questName).get(0);

        /*for (Quest quest : quests) {
            if (quest.getName().equals(questName)) {
                return quest;
            }
        }
        return null;*/
    }

    @Transactional //makes sure that database has completed method before continuing
    public void deleteQuestByName(String name){
        this.questRepository.deleteByName(name);
         /*Quest quest = findQuestByName(name);
        this.quests.remove(quest);*/

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
