package com.isep.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Enemy extends Combatant {
    private int ptsDegats;
    private String nameClass="enemy";
    @Override
    public String getNameClass() {return this.nameClass;}
    public Enemy(int ptsVie, String name, int ptsDegats) {
        super(ptsVie, name);
        this.ptsDegats=ptsDegats;
    }

    @Override
    public void attaque(Combatant cible){
        cible.loosePv(this.ptsDegats);
    }
}
