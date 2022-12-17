package com.isep.rpg.Heros;

import com.isep.rpg.Combatant;
import com.isep.rpg.Hero;
import com.isep.rpg.Item;
import com.isep.rpg.Items.Weapon;
import com.isep.rpg.SpellCaster;

import java.util.List;

public class Healer extends SpellCaster {

    private String nameClass="healer";
    @Override
    public String getNameClass() {return this.nameClass;}

    public Healer(String name) {
        super(30,name);

    }


    @Override
    public void attaque(Combatant cible) {
        if (super.canAttaque())
            cible.loosePv(-this.getWeapon().getDamage());
    }

    @Override
    public Weapon getWeapon() {
        return super.getWeapon();
    }
}
