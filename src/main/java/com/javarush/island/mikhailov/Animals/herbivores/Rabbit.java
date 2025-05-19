package com.javarush.island.mikhailov.Animals.herbivores;

import com.javarush.island.mikhailov.annotation.Organism;
import com.javarush.island.mikhailov.organizm.Limit;

@Organism(name = "кролик", icon = "\uD83D\uDC07", maxWeight = 2, maxCountInCell = 150, maxSpeed = 2,maxFood = 0.45, flockSize = 50)
public class Rabbit extends Herbivores{
    public Rabbit(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
