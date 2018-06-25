package app;

import app.entity.*;

/**
 * The Application program implements an application that
 * creates heroes and displays in the console
 * the fight outcome of two of them.
 */
public class Application {
    public static void main(String[] args) {
        //Creating some heroes
        Hero knight = new Knight("The Hound");
        Hero assassin = new Assassin("Altaïr");
        Hero warrior = new Warrior("Borimechkata");
        Hero monk = new Monk("Gandalf");

        //Adding two of the heroes to the game engine
        GameEngine gameEngine = new GameEngine(assassin, monk);

        //Starting the game engine
        System.out.println(gameEngine.fight());
    }
}
