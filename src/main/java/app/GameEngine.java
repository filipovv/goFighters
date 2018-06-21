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
     * @param firstHero  This is the hero who is going to make an attack
     * @param secondHero This is the hero who is going to defend himself
     * @return String value, representing the outcome of the current attack.
     */
    private String attack(Hero firstHero, Hero secondHero) {
        StringBuilder attackOutcome = new StringBuilder();
        attackOutcome.append(String.format("%s is attacking %s.", firstHero.getName(), secondHero.getName()))
                .append(System.lineSeparator())
                .append(secondHero.takeDamage(firstHero.attack()))
                .append(System.lineSeparator());
        if (!secondHero.isAlive()) {
            attackOutcome.append(String.format("%n%s is the winner!", this.firstHero.getName()))
                    .append(System.lineSeparator());
        }
        return attackOutcome.toString();
    }

    /**
     * This method is used for starting the game engine. It forces attack
     * from one hero to another until one of them dies and a winner is proclaimed.
     *
     * @return String value, representing the fight log.
     */
    public String fight() {
        StringBuilder fightResult = new StringBuilder();
        fightResult.append(this.gameIntro());
        while (this.firstHero.isAlive()) {
            fightResult.append(this.attack(firstHero, secondHero))
                    .append(System.lineSeparator());
            if (!secondHero.isAlive()) {
                break;
            }
            fightResult.append(this.attack(secondHero, firstHero))
                    .append(System.lineSeparator());
        }
        return fightResult.toString();
    }

    /**
     * Method used to provide game intro information.
     *
     * @return String value, representing the game intro.
     */
    private String gameIntro() {
        return "The battle is about to begin!" + System.lineSeparator() +
                String.format("Hero one - %s%nHero two - %s%n", this.firstHero.toString(), this.secondHero.toString()) + "Fight!" + System.lineSeparator();
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
