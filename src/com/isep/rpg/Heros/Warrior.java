package com.isep.rpg.Heros;

import com.isep.rpg.Combatant;
import com.isep.rpg.Hero;
import com.isep.rpg.Item;

import java.util.List;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(50, name);
    }
    private String nameClass="warrior";
    @Override
    public String getNameClass() {return this.nameClass;}
    @Override
    public void attaque(Combatant cible) {
        cible.loosePv(this.getWeapon().getDamage());
    }


}
