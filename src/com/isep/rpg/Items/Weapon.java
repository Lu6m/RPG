package com.isep.rpg.Items;

import com.isep.rpg.Item;

public class Weapon extends Item {
    private String name;
    private Integer degatscause;
    public Weapon (String name, Integer degatscause) {
        super();
        this.name=name;
        this.degatscause=degatscause;
    }

    public int getDamage(){
        return degatscause;
    }


}
