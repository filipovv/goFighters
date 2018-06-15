package app;

import app.models.*;

public class Application {
    public static void main(String[] args) {
        Hero firstHero = new Knight("The Hound");
        Hero secondHero = new Assassin("Ezio");

        GameEngine gameEngine = new GameEngine(firstHero, secondHero);

        System.out.println(gameEngine.fight());
    }
}
