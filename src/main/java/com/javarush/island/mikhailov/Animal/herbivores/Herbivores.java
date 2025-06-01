package com.javarush.island.mikhailov.Animal.herbivores;

import com.javarush.island.mikhailov.Animal.Animals;
import com.javarush.island.mikhailov.Animal.plants.Grass;
import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.organizm.Organism;

import java.util.Optional;

public class Herbivores extends Animals {

    public Herbivores(int COUNT_IN_CELL, String ICON, double MAX_WEIGHT_ORGANISM, int SPEED) {
        super(COUNT_IN_CELL, ICON, MAX_WEIGHT_ORGANISM, SPEED);

    }

    @Override
    public void eat(Cell currentCell) {
        Optional<Organism> has = currentCell.getOrganism().stream()
                .filter(a -> a instanceof Grass)
                .filter(a -> a.getCurrent_weight() > 0)
                .findAny();
if(!has.isEmpty()){
    Organism organism = has.get();
    organism.getLock().lock();
    try {
        double currentWeight = this.getCurrent_weight();
        double maxWeightOrganism = this.getMAX_WEIGHT_ORGANISM();
        double currentWeight1 = organism.getCurrent_weight();
        double  availableWeight = maxWeightOrganism - currentWeight;
        double min = Math.min(availableWeight, currentWeight1);
        this.setCurrent_weight(currentWeight+min);
        currentCell.getOrganism().remove(organism);
        this.setHungry(false);
    }finally {
        organism.getLock().unlock();
    }
}
    }
}
