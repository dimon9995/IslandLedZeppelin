package com.javarush.island.mikhailov.Animals.herbivores;

import com.javarush.island.mikhailov.Animals.Animal;
import com.javarush.island.mikhailov.organizm.Limit;

public abstract class Herbivores extends Animal {

    public Herbivores(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
