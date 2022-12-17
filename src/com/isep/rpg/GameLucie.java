package com.isep.rpg;

import com.isep.rpg.Heros.Healer;
import com.isep.rpg.Heros.Hunter;
import com.isep.rpg.Heros.Mage;
import com.isep.rpg.Heros.Warrior;
import com.isep.rpg.Items.Weapon;


import java.util.*;

public class GameLucie {
    public GameLucie() {
        nbPerso();
        createAllHeros();
        for (int i=1;i<=nbPartMax;i++) {
            createAllEnemy();
            triAllCombatant();
            playManche();
            if (nbPart < nbPartMax) {
                upgrade();
            }
        }
    }

    private int nbp;
    private int nbPart = 0;
    private int nbPartMax=5;

    private int nbTour=0;
    private ArrayList<Combatant> listHero = new ArrayList<Combatant>();
    private ArrayList<Combatant> listMechant = new ArrayList<Combatant>();
    private ArrayList<Combatant> listCombattant = new ArrayList<Combatant>();
    private ArrayList<Combatant> listCombattantvivants = new ArrayList<Combatant>();

    public void nbPerso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many People do you want ?");
        int nbp = scanner.nextInt();
        if (nbp == 0 || nbp < 0) {
            System.out.println("Impossible, veuillez changer de nombre");
            nbPerso();
        }
        this.nbp = nbp;
    }


    public void createAllHeros() {
        //int [] type =new int[this.nbp];
        for (int i = 0; i < this.nbp; i++) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Which warrior(s) do you want ?" + "\n" + "1 = Healer \n2 = Mage \n3 = Hunter \n4 = Warrior");
            //type[i] = (scanner.nextInt());
            int numHero = (scanner1.nextInt());

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("What is your name ?");
            String name = scanner2.nextLine();

            Hero hero ;
            switch (numHero) {
                case 1 ->{ hero=new Healer(name);
                    hero.addWeapon(new Weapon("Pansement",20));}
                case 2 -> {hero=new Mage(name);
                    hero.addWeapon(new Weapon("Baguette",25));}
                case 3 -> {hero=new Hunter(name);
                    hero.addWeapon(new Weapon("Fleche",15));}
                case 4 -> {hero=new Warrior(name);
                    hero.addWeapon(new Weapon("Main nu",21));}
                default -> {hero=new Warrior(name);
                    hero.addWeapon(new Weapon("Main nu",21));}
            };
            this.listHero.add(hero);
        }
    }
    public void nameAllHeros(){
        for (Combatant k:this.listHero) {
            System.out.println(k.getName()+" - "+k.getNameClass()+" - "+k.getptsVie());
        }
    }
    public void createAllEnemy() {
        for (int i = 0; i < this.nbPart + this.nbp; i++) {
            Random rand = new Random();
            int aleatoire = rand.nextInt(9) + 1;
            Combatant mechant = switch (aleatoire) {
                case 1 -> new Enemy(20, "Sauron", 5);
                case 2 -> new Enemy(30, "Melkor", 7);
                case 3 -> new Enemy(35, "Palpatine", 10);
                case 4 -> new Enemy(40, "Ganondorf", 12);
                case 5 -> new Enemy(45, "Voldemort", 14);
                case 6 -> new Enemy(50, "Gumbas", 17);
                case 7 -> new Enemy(55, "Frollo", 20);
                case 8 -> new Enemy(60, "Scar", 23);
                case 9 -> new Enemy(70, "Bowser", 30);
                default -> new Enemy(20, "Sauron", 5);
            };
            this.listMechant.add(mechant);
        }
    }
    public void nameAllEnemy(){
        for (Combatant k:this.listMechant) {
            System.out.println(k.getName()+" - "+k.getNameClass()+" - "+k.getptsVie());
        }
    }
    public void triAllCombatant() {
        this.listCombattant.addAll(this.listHero);
        this.listCombattant.addAll(this.listMechant);
        Collections.shuffle(this.listCombattant);
        this.listCombattantvivants= (ArrayList<Combatant>) this.listCombattant.clone();
    }

    public void nameAllCombatant(){
        for (Combatant k:this.listCombattant) {
            System.out.println(k.getName()+" - "+k.getNameClass()+" - "+k.getptsVie());
        }
    }
    public void nameAllItem(Combatant cbtt){
        for (Consumable k:((Hero)cbtt).getInventaire()) {
            System.out.println(k.getName()+" - "+k.getNameClass());
        }
    }

    public void playTour() {
        nameAllCombatant();
        for (Combatant cbt: this.listCombattant) {
            // Si ma liste contient le combattant
            if (this.listCombattantvivants.contains(cbt));{
                // si c'est au tour d'un hero
                if (cbt instanceof Hero) {
                    ((Hero) cbt).looseProtection();
                    // Choix entre 3 actions
                    System.out.println("What do you want to do ? \n1- Attack \n2- Defend \n3- Open up inventory");
                    Scanner sc1 = new Scanner(System.in);
                    int choix = sc1.nextInt();
                    // Execution d'une des actions
                    switch (choix) {
                        case 1: {
                            ArrayList<Combatant> listAttaque;
                            if (cbt instanceof Healer) {
                                listAttaque = this.listHero;
                                nameAllHeros();
                            }
                            else {
                                listAttaque = this.listMechant;
                                nameAllEnemy();
                            }
                            // Choix de la cible
                            Combatant cible;
                            System.out.println("Who do you wish to attack ? \nChoose a number between 1 and " + listAttaque.size());
                            Scanner sc2 = new Scanner(System.in);
                            int numEnemy = sc2.nextInt() - 1;
                            // Attaque de la cible
                            cbt.attaque(listAttaque.get(numEnemy));
                            if (listAttaque.get(numEnemy).getptsVie() <= 0) {
                                this.listCombattantvivants.remove(listAttaque.get(numEnemy));
                                listAttaque.remove(numEnemy);
                                break;
                            }

                        }
                        case 2: {
                            System.out.println("Protection");
                            ((Hero) cbt).addProtection();
                            break;
                        }
                        case 3: {
                            System.out.println("Utilisation objet");
                            nameAllItem(cbt);
                            System.out.println("What item would you like to use ? \nChoose a number between 1 and " + ((Hero) cbt).getInventaire().size());
                            Scanner sc3 = new Scanner(System.in);
                            int numObjet = sc3.nextInt();
                            ((Hero) cbt).useItem(((Hero) cbt).getInventaire().get(numObjet-1));
                            break;
                        }
                    }
                }
                // Si c'est un mechant
                else if (cbt instanceof Enemy) {
                    System.out.println("It's the enemy's turn, you have nothing to do\n");
                    Collections.shuffle(this.listHero);
                    ((Enemy) cbt).attaque((Hero) listHero.get(0));
                    int ptsVie = listHero.get(0).getptsVie();
                    System.out.println(cbt.getName() + " attaque " + listHero.get(0).getName());

                    if (ptsVie <= 0) {
                        System.out.println(listHero.get(0).getName() + " est décédé");
                        this.listCombattantvivants.remove(listHero.get(0));
                        this.listHero.remove(listHero.get(0));
                    } else
                        System.out.println(listHero.get(0).getName() + " possède maintenant " + ptsVie + " de vie");
                }
            }
        }
    }
/*
        int choix = scanner.nextInt();
        /*
        * choix 1er perso
        * boucle sur listCombattant //vague
        * if héro
        *   choix action
        *   action
        * if enemy
        *   choix hasard hero
        *   attaque
         */



    public void playManche(){
        while (!listMechant.isEmpty() & !listHero.isEmpty()) {
            this.nbTour++;
            this.playTour();
        }
    }
    public void upgrade(){

    }
}