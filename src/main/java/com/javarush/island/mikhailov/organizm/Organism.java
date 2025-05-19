package com.javarush.island.mikhailov.organizm;


public abstract class Organism implements Cloneable {
    String name;
    String icon;
    Limit limit;

    public Organism(String icon, String name, Limit limit) {

        this.icon = icon;
        this.name = name;
        this.limit = limit;
    }

    @Override
    public Organism clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            Organism clone = (Organism) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
