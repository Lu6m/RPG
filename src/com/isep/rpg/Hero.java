package com.isep.rpg;

import com.isep.rpg.Items.Food;
import com.isep.rpg.Items.Potion;
import com.isep.rpg.Items.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Hero extends Combatant {
    protected List<Consumable> inventaire;
    public List<Consumable> getInventaire() {return this.inventaire;}
    private int nbPart=0;

    private Weapon weapon;
    private int bouclier;

    public Hero(int ptsVie, String name) {
        super(ptsVie, name);
        createLuggage();
    }
    public abstract void attaque(Combatant cible);
    public void addProtection(){
        this.bouclier=10;}
    public void looseProtection(){
        this.bouclier=0;}
    @Override
    public void loosePv(int ptsDegats) {
        if (ptsDegats > this.bouclier) {
            ptsVie = ptsVie - (ptsDegats - this.bouclier);
            looseProtection();
            }
        }


    public void setWeapon(Weapon weapon) {this.weapon=weapon;}
    public Weapon getWeapon() {return this.weapon;}
    public void createLuggage(){
        this.nbPart=2;
        this.inventaire = new ArrayList<>();
        for (int i =1; i<=this.nbPart; i++) {
            Random rand = new Random();
            int aleatoire = rand.nextInt(5) + 1;
            int aleatoire2 = rand.nextInt(5) + 6;
            addConsumn(aleatoire);
            addConsumn(aleatoire2);
        }
    }

    public void addConsumn(int num) {
        switch (num) {
                // Add new Potion
            case 1:
                this.inventaire.add(new Potion("Pixie Pulveris", 10));break;
            case 2:
                this.inventaire.add(new Potion("Ital", 20));break;
            case 3:
                this.inventaire.add(new Potion("Fecske", 30));break;
            case 4:
                this.inventaire.add(new Potion("Serleg", 40));break;
            case 5:
                this.inventaire.add(new Potion("Sublimatum", 50));break;

                // Add new Food
            case 6:
                this.inventaire.add(new Food("Viz",10));break;
            case 7:
                this.inventaire.add(new Food("Leves", 20));break;
            case 8:
                this.inventaire.add(new Food("Torta", 30));break;
            case 9:
                this.inventaire.add(new Food("Gyümölcs", 40));break;
            case 10:
                this.inventaire.add(new Food("Amblance",50));break;

        }
    }

    public void useItem(Consumable useItem){
        if (useItem instanceof Food) {
            ptsVie += (useItem.getValue());
            this.inventaire.remove(useItem);
        }

    }
    public void addWeapon(Weapon weapon){
        this.weapon=weapon;

    }
}
