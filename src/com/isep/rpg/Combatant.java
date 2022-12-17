package com.isep.rpg;

public abstract class Combatant {
    protected int ptsVie;
    private String name;

    public Combatant(int ptsVie, String name) {
        this.ptsVie = ptsVie;
        this.name=name;
    }

    public String getName() {return this.name;}

    public void loosePv(int ptsDegats){
        ptsVie=ptsVie-ptsDegats;
    }

    public int getptsVie(){return this.ptsVie;}
    public abstract String getNameClass();
    public abstract void attaque(Combatant cible);
}
