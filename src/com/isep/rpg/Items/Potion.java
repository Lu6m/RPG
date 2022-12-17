package com.isep.rpg.Items;

import com.isep.rpg.Consumable;

public class Potion extends Consumable {

    private String nameClass="potion";
    @Override
    public String getNameClass() {return this.nameClass;}

    public Potion(String name, int pts) {
        super(name, pts);
    }


}
