package com.javarush.island.mikhailov.organizm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Limit  {
    private final int maxCountInCell;
    private final double maxWeight;
    private final int maxSpeed;
    private final double maxFood;
    private final int flockSize;
}
