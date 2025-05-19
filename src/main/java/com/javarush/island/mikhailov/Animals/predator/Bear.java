package com.javarush.island.mikhailov.Animals.predator;

import com.javarush.island.mikhailov.annotation.Organism;
import com.javarush.island.mikhailov.organizm.Limit;

@Organism(name = "медведь", icon = "\uD83D\uDC3B", maxWeight = 500, maxCountInCell = 5, maxSpeed = 2, maxFood = 80)
public class Bear extends Predator{
    public Bear(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
