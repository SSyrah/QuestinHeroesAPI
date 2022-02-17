package com.example.Heroes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface QuestRepository extends JpaRepository<Quest, Long> {
    ArrayList<Quest> findByName(String name);
    //ArrayList<Quest> findByNameAndDifficulty(String name, int difficulty);
    Long deleteByName(String name);

}
