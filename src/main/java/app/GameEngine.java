package app;

import app.models.Hero;

public class GameEngine {
    private Hero firstHero;
    private Hero secondHero;

    public GameEngine(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    private String attack(Hero firstHero, Hero secondHero) {
        return String.format("%s is attacking %s.", firstHero.getName(), secondHero.getName()) + System.lineSeparator() +
                secondHero.takeDamage(firstHero.attack()) + System.lineSeparator();
    }

    public String fight() {
        StringBuilder fightResult = new StringBuilder();
        fightResult.append("The battle is about to begin!").append(System.lineSeparator())
                .append(String.format("Hero one - %s%nHero two - %s%n", this.firstHero.toString(), this.secondHero.toString())).append("Fight!").append(System.lineSeparator());
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
