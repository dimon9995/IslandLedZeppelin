package com.javarush.island.mikhailov.Animals.herbivores;

import com.javarush.island.mikhailov.annotation.Organism;
import com.javarush.island.mikhailov.organizm.Limit;

@Organism(name = "олень", icon = "\uD83E\uDD8C", maxWeight = 300, maxCountInCell = 20, maxSpeed = 4, flockSize = 5, maxFood = 50)
public class Deer extends Herbivores{
    public Deer(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
