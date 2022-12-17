package com.isep.rpg.Heros;

import com.isep.rpg.Combatant;
import com.isep.rpg.Hero;
import com.isep.rpg.Item;
import com.isep.rpg.Items.Weapon;

import java.util.List;

public class Hunter extends Hero {
    public Hunter(String name) {
        super(50, name);
    }

    private String nameClass="hunter";
    @Override
    public String getNameClass() {return this.nameClass;}
    @Override
    public void attaque(Combatant cible) {
        cible.loosePv(this.getWeapon().getDamage());
        }
    }

