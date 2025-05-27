package com.javarush.island.mikhailov.Animal;

import com.javarush.island.mikhailov.Interface.Eating;
import com.javarush.island.mikhailov.Interface.Movable;
import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.config.field.Map;
import com.javarush.island.mikhailov.organizm.Organism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animals extends Organism implements Eating, Movable {

    public Animals(int COUNT_IN_CELL, String ICON, double MAX_WEIGHT_ORGANISM, int SPEED) {
        super(COUNT_IN_CELL, ICON, MAX_WEIGHT_ORGANISM, SPEED);
    }

    private int compareCells(Cell a, Cell b) {
        if (a.getX() != b.getX()) {
            return Integer.compare(a.getX(), b.getX());
        }
        return Integer.compare(a.getY(), b.getY());
    }

    private Cell anotherCell(Cell[][] map, Cell currentCell, int stepLimit) {
        int widthX = map.length;
        int heightY = map[0].length;
        int x = currentCell.getX();
        int y = currentCell.getY();
        List<Cell> coordinate = new ArrayList<>();

        if (x + stepLimit < widthX) {

            coordinate.add(map[x + stepLimit][y]);
        }
        if (x - stepLimit >= 0) {
            coordinate.add(map[x - stepLimit][y]);
        }
        if (y + stepLimit < heightY) {
            coordinate.add(map[x][y + stepLimit]);
        }
        if (y - stepLimit >= 0) {
            coordinate.add(map[x][y - stepLimit]);
        }
        coordinate.add(currentCell);

        Collections.shuffle(coordinate);
        for (Cell targetCell : coordinate) {


            if (!targetCell.getLock().tryLock()) continue;

            try {
                long sameTypeCount = targetCell.getOrganism().stream()
                        .filter(o -> this.getClass().isInstance(o))
                        .count();

                if (sameTypeCount < this.getCOUNT_IN_CELL()) {
                    return targetCell;
                }


            } finally {
                targetCell.getLock().unlock();
            }
        }
        return currentCell;
    }

    @Override
    public void eat(Cell currentCell) {

    }

    @Override
    public void move(Cell currentCell, Map map) {
        this.getLock().lock();
        try {
            int stepLimit = ThreadLocalRandom.current().nextInt(1, this.getCOUNT_IN_CELL() + 1);
            if (this.getCurrent_weight() > this.getPENALTY_PER_MOVE() * stepLimit) {
                Cell cell = anotherCell(map.getMap(), currentCell, stepLimit);
                if (cell != currentCell) {
                    Cell firstLockCell;
                    Cell secondLockCell;
                    if (compareCells(currentCell, cell) < 0) {
                        firstLockCell = currentCell;
                        secondLockCell = cell;
                    } else {
                        firstLockCell = cell;
                        secondLockCell = currentCell;
                    }
                    firstLockCell.getLock().lock();
                    try {
                        secondLockCell.getLock().lock();

                        try {
                            currentCell.getOrganism().remove(this);
                            cell.getOrganism().add(this);
                            this.setCountOfStep(this.getCountOfStep() + 1);
                            this.setCurrent_weight(getCurrent_weight() - this.getPENALTY_PER_MOVE() * stepLimit);
                        } finally {
                            secondLockCell.getLock().unlock();
                        }
                    } finally {
                        firstLockCell.getLock().unlock();
                    }
                }
            }
        } finally {
            this.getLock().unlock();
        }
    }
}
