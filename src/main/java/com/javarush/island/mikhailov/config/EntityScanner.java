package com.javarush.island.mikhailov.config;


import com.javarush.island.mikhailov.organizm.Organism;


public class EntityScanner {

    private EntityScanner() {
    }

    public static Organism[] createPrototype(Class<?>[] TYPES) {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {

            }



        return organisms;
    }
}
