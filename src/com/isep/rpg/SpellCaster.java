package com.isep.rpg;

import com.isep.rpg.Hero;
import com.isep.rpg.Items.Food;
import com.isep.rpg.Items.Potion;

import java.util.List;

public abstract class SpellCaster extends Hero {
    private int doseMana=50;
    public int getDoseMana() {return this.doseMana;}
    private int manaUtilise=10;

    public SpellCaster(int ptsVie, String name) {
        super(ptsVie, name);
    }


    public boolean canAttaque() {
        if (doseMana>=manaUtilise) {
            doseMana-= manaUtilise;
            return true;}
        return false;
    }

    @Override
    public void useItem(Consumable useItem){
        super.useItem(useItem);
        if (useItem instanceof Potion){
            doseMana += (useItem.getValue());
            this.inventaire.remove(useItem);
        }

    }
}

