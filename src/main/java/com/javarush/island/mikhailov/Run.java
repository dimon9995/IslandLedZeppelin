package com.javarush.island.mikhailov;

import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.config.field.Map;
import com.javarush.island.mikhailov.organizm.FactoryOrganism;
import com.javarush.island.mikhailov.organizm.Task;
import com.javarush.island.mikhailov.organizm.View;
import lombok.ToString;

@ToString
public class Run {
    public static void main(String[] args) {
        int height = 10; // например
        int width = 10;
        Map map = new Map(height, width);
        FactoryOrganism factoryOrganism = new FactoryOrganism();
        Cell[][] cells = factoryOrganism.init(map.getMap());
        map.setMap(cells);

        View viewer = new View();
        Task task = new Task(viewer, map);
        Thread thread = new Thread(task);
        thread.start();
    }
}
