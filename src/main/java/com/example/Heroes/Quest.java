package com.example.Heroes;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Quest {
    private String name;
    private int difficulty;

}