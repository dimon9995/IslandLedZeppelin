package com.javarush.island.mikhailov.config.field;

import com.javarush.island.mikhailov.config.Cell;
import lombok.Data;

@Data
public class Map {
    private Cell[][] map;
    int height;
    int width;

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.map = new Cell[height][width];
    }
}

