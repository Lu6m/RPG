package com.isep.rpg;

public abstract class Consumable extends Item{
    private String name;
    private int pts;
    public abstract String getNameClass();
    public String getName() {return this.name;}

    public Consumable (String name, int pts) {
        super();
        this.name=name;
        this.pts=pts;

    }

    public int getValue(){
        return this.pts;
    }
}

