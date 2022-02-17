package com.example.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    @Override
    ArrayList<Hero> findAll();
    ArrayList<Hero> findByName(String name);

}
