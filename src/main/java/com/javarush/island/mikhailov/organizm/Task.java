package com.javarush.island.mikhailov.organizm;

import com.javarush.island.mikhailov.config.field.Map;
import lombok.Data;

@Data
public class Task implements Runnable {
    private View viewer;
    private volatile Map map;

    public Task(View viewer, Map map) {
        this.viewer = viewer;
        this.map = map;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                viewer.scan(map.getMap());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

