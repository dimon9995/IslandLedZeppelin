package com.javarush.island.mikhailov.Interface;

import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.config.field.Map;


public interface Movable {
    void move(Cell currentCell, Map map);
}
