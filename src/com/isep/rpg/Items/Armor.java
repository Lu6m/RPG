package com.isep.rpg.Items;

import com.isep.rpg.Item;

public class Armor extends Item {
    private String name;
    private Integer resistance;
    public Armor (String name, Integer resistance) {
        super();
        this.name =name;
        this.resistance=resistance;
    }

    public int getResistance(){
        return resistance;
    }

}
