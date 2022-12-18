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
        for (int i=1;i<=nbPartieMax;i++) {
            createAllEnemy();
            triAllCombatant();
            playManche();
            this.nbPartie++;
            if (nbPartie < nbPartieMax) {
                upgrade();
            }
        }
    }

    private int nbp;
    private int nbPartie = 0;
    private int nbPartieMax=5;

    private int nbTour=0;
    private ArrayList<Combatant> listHero = new ArrayList<Combatant>();
    private ArrayList<Combatant> listMechant = new ArrayList<Combatant>();
    private ArrayList<Combatant> listCombattant = new ArrayList<Combatant>();
    private ArrayList<Combatant> listCombattantvivants = new ArrayList<Combatant>();

    public void nbPerso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players do you want ?");
        int nbp = scanner.nextInt();
        if (nbp == 0 || nbp < 0) {
            System.out.println("Impossible, please change number");
            nbPerso();
        }
        //On récupère le nombre de joueurs souhaité
        this.nbp = nbp;
    }


    public void createAllHeros() {
        for (int i = 0; i < this.nbp; i++) {
            //Pour chaque joueur, on demande son type et son nom.
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Which type of warrior(s) do you want ?" + "\n" + "1 = Healer \n2 = Mage \n3 = Hunter \n4 = Warrior");
            int numHero = (scanner1.nextInt());
            while (numHero>4 || numHero<1){
                System.out.println("The type you have asked for does not exist. Please choose an existing one.");
                System.out.println("Which type of warrior(s) do you want ?" + "\n" + "1 = Healer \n2 = Mage \n3 = Hunter \n4 = Warrior");
                numHero = (scanner1.nextInt());
            }

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("What is your name ?");
            String name = scanner2.nextLine();

            //On associe alors une arme à ce joueur. On contruit alors une liste constitué de tous les héros
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
    //On récupère tous les noms des Héros, ainsi que leur type et leur nombre de point de vie à un instant T
    public void nameAllHeros(){
        int nb=0;
        for (Combatant k:this.listHero) {
            nb++;
            System.out.println(nb + " - " + k.getName() + " - " + k.getNameClass() + " - " + k.getptsVie());

        }
    }

    //On créé une liste d'ennemis dont le nombre dépendra de dans quelle manche est le joueur
    public void createAllEnemy() {
        for (int i = 0; i < this.nbPartie + this.nbp; i++) {
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
    //On récupère tous les noms des Ennemis, ainsi que leur type et leur nombre de point de vie à un instant T
    public void nameAllEnemy(){
        int nb=0;
        for (Combatant k:this.listMechant) {
            nb++;
            System.out.println(nb + " - " + k.getName() + " - " + k.getNameClass() + " - " + k.getptsVie());
        }
    }
    //On créé une liste dans laquelle on mélange les héros et les ennemis, puis on mélange la liste pour obtenir un
    //ordre de jeu aléatoire.
    public void triAllCombatant() {
        this.listCombattant.addAll(this.listHero);
        this.listCombattant.addAll(this.listMechant);
        Collections.shuffle(this.listCombattant);
        this.listCombattantvivants= (ArrayList<Combatant>) this.listCombattant.clone();
    }

    //On récupère tous les noms des Ennemis et des Héros, ainsi que leur type et leur nombre de point de vie à un instant T
    public void nameAllCombatant(){
        int nb=0;
        for (Combatant k:this.listCombattant) {
            nb++;
            System.out.println(nb+" - "+k.getName()+" - "+k.getNameClass()+" - "+k.getptsVie());
        }
    }
    public void nameAllItem(Combatant cbtt){
        int nb=0;
        for (Consumable k:((Hero)cbtt).getInventaire()) {
            nb++;
            System.out.println(nb+" - "+k.getName()+" - "+k.getNameClass());
        }
    }

    public void playTour() {
        nameAllCombatant();
        for (Combatant cbt: this.listCombattant) {
            // Si ma liste contient le combattant (donc qu'il n'est pas mort)
            if (this.listCombattantvivants.contains(cbt));{
                // si c'est au tour d'un hero
                if (cbt instanceof Hero) {
                    ((Hero) cbt).looseProtection();
                    //Affichage du héro avec lequel on va se battre
                    if (cbt instanceof Healer || cbt instanceof Mage) {
                        System.out.println("It is " + cbt.getName() + "'s turn! Characteristics:\n" + "Type: " + cbt.getNameClass() + " / Life: " + cbt.ptsVie + " / Mana: " + ((SpellCaster) cbt).getDoseMana());
                    }else
                        System.out.println("It is " + cbt.getName() + "'s turn! Characteristics:\n" + "Type :" + cbt.getNameClass() + "Life: " + cbt.ptsVie);
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
                                System.out.println("Who do you wish to help ? \nChoose a number between 1 and " + listAttaque.size());
                                nameAllHeros();
                            }
                            else {
                                listAttaque = this.listMechant;
                                System.out.println("Who do you wish to attack ? \nChoose a number between 1 and " + listAttaque.size());
                                nameAllEnemy();
                            }
                            // Choix de la cible
                            Scanner sc2 = new Scanner(System.in);
                            int numEnemy = sc2.nextInt() - 1;
                            // Attaque de la cible
                            cbt.attaque(listAttaque.get(numEnemy));
                            // Si l'ennemi attaqué n'a pluys de point de vie, alors il disparait des listes
                            if (listAttaque.get(numEnemy).getptsVie() <= 0) {
                                this.listCombattantvivants.remove(listAttaque.get(numEnemy));
                                listAttaque.remove(numEnemy);
                            }
                            break;
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
                    System.out.println("It's the enemy's turn, you have nothing to do");
                    Collections.shuffle(this.listHero);
                    ((Enemy) cbt).attaque((Hero) listHero.get(0));
                    int ptsVie = listHero.get(0).getptsVie();
                    System.out.println(cbt.getName() + " attaque " + listHero.get(0).getName());

                    if (ptsVie <= 0) {
                        System.out.println(listHero.get(0).getName() + " est décédé \n");
                        this.listCombattantvivants.remove(listHero.get(0));
                        this.listHero.remove(listHero.get(0));
                    } else
                        System.out.println(listHero.get(0).getName() + " possède maintenant " + ptsVie + " de vie\n");
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