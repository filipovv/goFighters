package app;

import app.models.Hero;

public class GameEngine {
    private Hero firstHero;
    private Hero secondHero;

    public GameEngine(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public String attack(Hero firstHero, Hero secondHero) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s is attacking %s.", firstHero.getName(), secondHero.getName())).append(System.lineSeparator());
        result.append(secondHero.takeDamage(firstHero.attack())).append(System.lineSeparator());
        return result.toString();
    }

    public String fight() {
        StringBuilder fightResult = new StringBuilder();
        while (this.firstHero.isAlive() && this.secondHero.isAlive()) {
            fightResult.append(this.attack(firstHero, secondHero)).append(System.lineSeparator());
            if (!secondHero.isAlive()) {
                fightResult.append(String.format("%s is the winner!", this.firstHero.getName())).append(System.lineSeparator());
                break;
            }
            fightResult.append(this.attack(secondHero, firstHero)).append(System.lineSeparator());
            if (!firstHero.isAlive()) {
                fightResult.append(String.format("%s is the winner!", this.secondHero.getName())).append(System.lineSeparator());
                break;
            }
        }
        return fightResult.toString();
    }
}
