package com.javarush.island.mikhailov.Animals.predator;

import com.javarush.island.mikhailov.annotation.Organism;
import com.javarush.island.mikhailov.organizm.Limit;

@Organism(name = "волк", icon = "🐺", maxWeight = 50, maxCountInCell = 30, flockSize = 15, maxSpeed = 3, maxFood = 8)
public class Wolf extends Predator {
    public Wolf(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
