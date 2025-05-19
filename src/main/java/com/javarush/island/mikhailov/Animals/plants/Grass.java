package com.javarush.island.mikhailov.Animals.plants;

import com.javarush.island.mikhailov.Animals.Animal;
import com.javarush.island.mikhailov.annotation.Organism;
import com.javarush.island.mikhailov.organizm.Limit;

@Organism(name = "Трава", icon = "\uD83E\uDEB4", maxWeight = 1, maxCountInCell = 200, flockSize = 20, maxSpeed = 0, maxFood = 0)
public class Grass extends Animal {
    public Grass(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
