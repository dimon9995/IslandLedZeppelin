package com.javarush.island.mikhailov;

import com.javarush.island.mikhailov.config.Cell;
import com.javarush.island.mikhailov.config.field.Map;
import com.javarush.island.mikhailov.organizm.FactoryOrganism;
import com.javarush.island.mikhailov.organizm.View;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

    public static void main(String[] args) {
        FactoryOrganism factoryOrganism = new FactoryOrganism();

        Map map = new Map(Constants.MAP_WIDTH, Constants.MAP_HEIGHT);
        Cell[][] initMap = factoryOrganism.init(map.getMap());
        map.setMap(initMap);

        Cell[][] cells = map.getMap();
        ExecutorService executor = Executors.newFixedThreadPool(Constants.QUANTITY_THREADS);
        View viewer = new View();


        while (true) {
            ArrayList<Callable<Void>> executionTasks = new ArrayList<>();
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    executionTasks.add(new ExecutorAnimals(cells[i][j], map));
                }
            }

            try {
                executor.invokeAll(executionTasks);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            viewer.scan(map.getMap());

            try {
                Thread.sleep(1_000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}

