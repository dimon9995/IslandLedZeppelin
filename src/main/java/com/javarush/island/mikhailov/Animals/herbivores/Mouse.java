package com.javarush.island.mikhailov.Animals.herbivores;

import com.javarush.island.mikhailov.annotation.Organism;
import com.javarush.island.mikhailov.organizm.Limit;

@Organism(name = "Мышка", icon = "\uD83D\uDC01", maxWeight = 0.05, maxCountInCell = 500,
        flockSize = 50, maxSpeed = 1, maxFood = 0.01)
public class Mouse extends Herbivores{
    public Mouse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
