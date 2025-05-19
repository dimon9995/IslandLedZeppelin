package com.javarush.island.mikhailov.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Organism {
    String name();
    String icon();

    double maxWeight();

    int maxCountInCell();

    int flockSize() default 1;

    int maxSpeed();

    double maxFood();
}
