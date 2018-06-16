package app;

import app.models.*;

public class Application {
    public static void main(String[] args) {
        Hero knight = new Knight("The Hound");
        Hero assassin = new Assassin("Altaïr");
        Hero warrior = new Warrior("Borimechkata");
        Hero monk = new Monk("Gandalf");

        GameEngine gameEngine = new GameEngine(warrior, knight);

        System.out.println(gameEngine.fight());
    }
}
