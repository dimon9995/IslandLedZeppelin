package com.javarush.island.mikhailov.organizm;


import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.config.field.Probability;

public class FactoryOrganism {
    public Cell[][]init(Cell[][] map ){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Cell cell = new Cell(i, j);
                for(String namesAnimals: Probability.NAMES_ANIMALS){
                    switch (namesAnimals){
                        case "Wolf":{



                        }
                    }
                }
            }
        }
        return null;
    }
}
