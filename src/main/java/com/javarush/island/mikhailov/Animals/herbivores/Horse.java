package com.javarush.island.mikhailov.Animals.herbivores;

import com.javarush.island.mikhailov.annotation.Organism;
import com.javarush.island.mikhailov.organizm.Limit;

@Organism(name = "Лошадка", icon = "\uD83D\uDC0E", maxWeight = 400, maxCountInCell = 20,
        flockSize = 10, maxSpeed = 4, maxFood = 60)
public class Horse extends Herbivores{
    public Horse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
