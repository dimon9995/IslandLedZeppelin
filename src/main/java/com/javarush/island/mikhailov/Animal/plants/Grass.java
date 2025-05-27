package com.javarush.island.mikhailov.Animal.plants;

import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.organizm.Organism;

import java.util.concurrent.ThreadLocalRandom;

public class Grass extends Organism {
    public Grass(int COUNT_IN_CELL, String ICON, double MAX_WEIGHT_ORGANISM, int SPEED) {
        super(200, "\uD83C\uDF3F", 1, 0);
    }

    @Override
    public void reproduce(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            long count = currentCell.getOrganism().stream().filter(a -> this.getClass().isInstance(a)).count();
            int countInCell = this.getCOUNT_IN_CELL();
            if (count < this.getCOUNT_IN_CELL()) {
                long missing = countInCell - count;
                long newCount = ThreadLocalRandom.current().nextLong(1, (missing + 1));
                for (int i = 0; i < newCount; i++) {
                    Organism organism;
                    synchronized (this) {
                        organism = this.clone();
                    }
                    currentCell.getOrganism().add(organism);
                }
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }
}
