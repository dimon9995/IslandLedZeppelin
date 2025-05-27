package com.javarush.island.mikhailov.config;

import com.javarush.island.mikhailov.organizm.Organism;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
@Data
@NoArgsConstructor
public class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    ArrayList<Organism> organism = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();
}
