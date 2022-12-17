package com.isep.rpg;

public class Game {

    public static Game option ;
    private Game() {}
    public static void playGame(){
        Game.option=new Game();
    }

    private int nbHeros;
    public void setNbHeros(int nbHeros) {this.nbHeros=nbHeros;}
    public int getNbHeros() {return this.nbHeros;}

}
