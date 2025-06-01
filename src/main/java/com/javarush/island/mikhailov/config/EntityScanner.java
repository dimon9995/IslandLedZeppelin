package com.javarush.island.mikhailov.config;

import com.javarush.island.mikhailov.organizm.Organism;

public class EntityScanner {
    private EntityScanner() {}

    public static Organism[] createPrototype(Class<? extends Organism>[] TYPES) {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<? extends Organism> type : TYPES) {
            try {
                organisms[index++] = type.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Не удалось создать прототип для: " + type.getSimpleName(), e);
            }
        }
        return organisms;
    }
}
