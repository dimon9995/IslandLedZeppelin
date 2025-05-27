package com.javarush.island.mikhailov.organizm;


import com.javarush.island.mikhailov.Interface.Reproduce;
import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.enums.Gender;
import lombok.Data;
import lombok.Getter;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Data
public abstract class Organism implements Reproduce, Cloneable {

    private final int COUNT_IN_CELL;
    private final String ICON;
    private final ReentrantLock lock = new ReentrantLock();
    private final double MAX_WEIGHT_ORGANISM;
    private double current_weight;
    private final int SPEED;
    private final Gender GENDER;
    private boolean hungry;
    private final double PENALTY_PER_MOVE;
    private int countOfStep = 0;

    public Organism(int COUNT_IN_CELL, String ICON, double MAX_WEIGHT_ORGANISM, int SPEED) {
        this.COUNT_IN_CELL = COUNT_IN_CELL;
        this.ICON = ICON;
        this.MAX_WEIGHT_ORGANISM = MAX_WEIGHT_ORGANISM;
        this.current_weight = ThreadLocalRandom.current().nextDouble(0, (MAX_WEIGHT_ORGANISM + 1));
        this.SPEED = SPEED;
        this.GENDER = Gender.getRandomGender();
        this.hungry = true;
        this.PENALTY_PER_MOVE = (this.current_weight * 0.05);
    }

    public void setCurrent_weight(double current_weight) {
        this.current_weight = current_weight;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public void setCountOfStep(int countOfStep) {
        this.countOfStep = countOfStep;
    }

    @Override
    public void reproduce(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            long herCount = currentCell.getOrganism().stream().filter(a -> this.getClass().isInstance(a)).count();
            if (herCount < this.getCOUNT_IN_CELL()) {
                Optional<Organism> her = currentCell.getOrganism().stream().filter(a -> this.getClass().isInstance(a))
                        .filter(a -> !a.getGENDER().equals(getGENDER()))
                        .findAny();
                if (her.isEmpty()) {
                    Organism organism = her.get();
                    organism.getLock().lock();
                    try {

                        Organism clone = (Organism) organism.clone();
                        currentCell.getOrganism().add(clone);
                        this.getLock().unlock();
                    } finally {
                        organism.getLock().unlock();
                    }

                }
            }

        } finally {
            this.setHungry(true);
            currentCell.getLock().unlock();
        }
    }


    @Override
    public Organism clone() {
        try {
            Organism clone = (Organism) super.clone();
            double weight = ThreadLocalRandom.current().nextDouble(current_weight / 2, current_weight);
            current_weight = weight;
            clone.hungry = true;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error clone organism", e);
        }
    }
    public void dead(Cell currentCell) {
        this.getLock().lock();
        currentCell.getLock().lock();
        try {
            if (this.countOfStep == 5) {
                currentCell.getOrganism().remove(this);
            }
        } finally {
            this.getLock().unlock();
            currentCell.getLock().unlock();
        }
    }
}
