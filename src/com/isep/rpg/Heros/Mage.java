package com.isep.rpg.Heros;

import com.isep.rpg.Combatant;
import com.isep.rpg.Item;
import com.isep.rpg.SpellCaster;

import java.util.List;

public class Mage extends SpellCaster {

    private String nameClass="mage";
    @Override
    public String getNameClass() {return this.nameClass;}
    public Mage(String name) {
        super(30, name);

    }

    @Override
    public void attaque(Combatant cible) {
        if (super.canAttaque())
            cible.loosePv(this.getWeapon().getDamage());
    }
}

