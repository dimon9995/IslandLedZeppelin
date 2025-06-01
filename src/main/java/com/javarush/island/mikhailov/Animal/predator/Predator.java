package com.javarush.island.mikhailov.Animal.predator;

import com.javarush.island.mikhailov.Animal.Animals;
import com.javarush.island.mikhailov.Animal.herbivores.Herbivores;
import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.organizm.Organism;
import java.util.Optional;

public class Predator extends Animals {
    public Predator(int COUNT_IN_CELL, String ICON, double MAX_WEIGHT_ORGANISM, int SPEED) {
        super(COUNT_IN_CELL, ICON, MAX_WEIGHT_ORGANISM, SPEED);
    }
    public void eat(Cell currentCell) {
        Optional<Organism> her = currentCell.getOrganism().stream()
                .filter(a -> a instanceof Herbivores)
                .filter(a -> a.getCurrent_weight() > 0.0)
                .findAny();
        if (her.isPresent()) {
            Organism org = her.get();
            org.getLock().lock();
            try {
                double currentWeight = this.getCurrent_weight();
                double maxWeight = this.getMAX_WEIGHT_ORGANISM();
                double otherWeight = org.getCurrent_weight();
                double availableWeight = maxWeight - currentWeight;
                double weightToAdd = Math.min(availableWeight, otherWeight);
                this.setCurrent_weight(currentWeight + weightToAdd);
                currentCell.getOrganism().remove(org);
                this.setHungry(false);
            } finally {
                org.getLock().unlock();
            }
        }
    }
}
