package com.isep.rpg.Items;

import com.isep.rpg.Consumable;

public class Food extends Consumable {

    private String nameClass="food";
    @Override
    public String getNameClass() {return this.nameClass;}
    public Food(String name, int pts) {
        super(name, pts);
    }
}


