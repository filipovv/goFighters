package app;

import app.entity.Hero;

/**
 * GameEngine simulates the fight outcome between two heroes. Heroes fight until one of them dies.
 */
public class GameEngine {
    private Hero firstHero;
    private Hero secondHero;

    /**
     * Constructor for the game engine
     *
     * @param firstHero  This is the first hero
     * @param secondHero This is the second hero
     */
    public GameEngine(Hero firstHero, Hero secondHero) {
        this.setFirstHero(firstHero);
        this.setSecondHero(secondHero);
    }

    /**
     * Method used for a hero to attack another hero
     *
     * @param fightResult This is the ongoing game log.
     * @param firstHero   This is the hero who is going to make an attack
     * @param secondHero  This is the hero who is going to defend himself
     */
    private void attack(StringBuilder fightResult, Hero firstHero, Hero secondHero) {
        fightResult.append(String.format("%s is attacking %s.", firstHero.getName(), secondHero.getName()))
                .append(System.lineSeparator())
                .append(secondHero.takeDamage(firstHero.attack()))
                .append(System.lineSeparator());
        if (!secondHero.isAlive()) {
            fightResult.append(String.format("%n%s is the winner!", firstHero.getName()))
                    .append(System.lineSeparator());
        }
        fightResult.append(System.lineSeparator());
    }

    /**
     * This method is used for starting the game engine. It forces attack
     * from one hero to another until one of them dies and a winner is proclaimed.
     *
     * @return String value, representing the fight log.
     */
    public String fight() {
        StringBuilder fightResult = new StringBuilder();
        this.gameIntro(fightResult);
        while (this.firstHero.isAlive()) {
            this.attack(fightResult, this.firstHero, this.secondHero);
            if (!this.secondHero.isAlive()) {
                break;
            }
            this.attack(fightResult, this.secondHero, this.firstHero);
        }
        return fightResult.toString();
    }

    /**
     * Method used to provide game intro information.
     *
     * @param fightResult This is the ongoing game log.
     */
    private void gameIntro(StringBuilder fightResult) {
        fightResult.append("The battle is about to begin!")
                .append(System.lineSeparator())
                .append(String.format("Hero one - %s%nHero two - %s%n", this.firstHero.toString(), this.secondHero.toString()))
                .append("Fight!")
                .append(System.lineSeparator());
    }

    private void setFirstHero(Hero firstHero) {
        if (firstHero == null) {
            throw new IllegalArgumentException("First hero cannot be null");
        }
        this.firstHero = firstHero;
    }

    private void setSecondHero(Hero secondHero) {
        if (secondHero == null) {
            throw new IllegalArgumentException("Second hero cannot be null.");
        }
        if (this.firstHero.equals(secondHero)) {
            throw new IllegalArgumentException("Second hero cannot be the same as the first one. Two are needed to play this game.");
        }
        this.secondHero = secondHero;
    }
}
