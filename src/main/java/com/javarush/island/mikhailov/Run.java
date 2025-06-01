package com.javarush.island.mikhailov;

import com.javarush.island.mikhailov.config.field.Map;
import com.javarush.island.mikhailov.organizm.FactoryOrganism;
import com.javarush.island.mikhailov.organizm.View;
import com.javarush.island.mikhailov.organizm.Task;
import lombok.ToString;

@ToString
public class Run {
    public static void main(String[] args) {
        int height = 10;
        int width = 10;
        Map map = new Map(height, width);
        FactoryOrganism factoryOrganism = new FactoryOrganism();
        map.setMap(factoryOrganism.init(map.getMap()));
        View viewer = new View();
        Task task = new Task(viewer, map);
        Thread thread = new Thread(task);
        thread.start();
    }
}
