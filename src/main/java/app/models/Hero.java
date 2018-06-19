package app.models;


import java.util.Random;

/**
 * Base class Hero used to provide basic functionality and properties to all classes that inherit it.
 */
public abstract class Hero {
    private static final double ATTACK_LOWER_BOUND_MULTIPLIER = 0.8;
    private static final double ATTACK_HIGHER_BOUND_MULTIPLIER = 1.2;
    private static final double DEFENCE_LOWER_BOUND_MULTIPLIER = 0.8;
    private static final double DEFENCE_HIGHER_BOUND_MULTIPLIER = 1.2;

    private String name;
    private int healthPoints;
    private int attackPoints;
    private int armorPoints;

    /**
     * Constructor for base class Hero
     *
     * @param name         The name of the hero
     * @param healthPoints The health points the hero has
     * @param attackPoints The attack points the hero has
     * @param armorPoints  The armor points the hero has
     */
    Hero(String name, int healthPoints, int attackPoints, int armorPoints) {
        this.setName(name);
        this.setHealthPoints(healthPoints);
        this.setAttackPoints(attackPoints);
        this.setArmorPoints(armorPoints);
    }

    /**
     * Method used to generate a random number between 1 and 100, mainly used for percentage calculations.
     *
     * @return Integer value, a random number between 1 and 100
     */
    int generateRandomNumberForChanceCalculation() {
        return this.calculateRandomNumberFromBounds(1, 100);
    }

    /**
     * Method used to generate a random number between given lower and higher bound.
     *
     * @param lowerBound  The lower bound for the random number generator
     * @param higherBound The higher bound for the random number generator
     * @return Integer value, a random number between the two bounds
     */
    int calculateRandomNumberFromBounds(int lowerBound, int higherBound) {
        Random random = new Random();
        return random.nextInt(higherBound - lowerBound) + lowerBound;
    }

    /**
     * Method used to calculate and simulate the attack action of the hero
     *
     * @return Integer value, representing the attack force of the hero in his current attack.
     */
    public int attack() {
        int lowerBound = (int) (this.getAttackPoints() * ATTACK_LOWER_BOUND_MULTIPLIER);
        int higherBound = (int) (this.getAttackPoints() * ATTACK_HIGHER_BOUND_MULTIPLIER);
        return this.calculateRandomNumberFromBounds(lowerBound, higherBound);
    }

    /**
     * Method used to calculate and simulate the defence of the hero
     *
     * @param damageTaken The damage received from the enemy attack
     * @return String value, representing the outcome of the received attack.
     */
    public String takeDamage(int damageTaken) {
        int lowerBound = (int) (this.getArmorPoints() * DEFENCE_LOWER_BOUND_MULTIPLIER);
        int higherBound = (int) (this.getArmorPoints() * DEFENCE_HIGHER_BOUND_MULTIPLIER);
        int shieldPoints = this.calculateRandomNumberFromBounds(lowerBound, higherBound);

        int healthPointsTaken = damageTaken - shieldPoints;

        this.setHealthPoints(this.getHealthPoints() - healthPointsTaken);
        if (this.getHealthPoints() <= 0) {
            this.setHealthPoints(0);
            return String.format("%s %s is dead.", this.getHeroType(), this.getName());
        }
        return String.format("%s %s took %d damage and is left with %d health points.", this.getHeroType(), this.getName(), healthPointsTaken, this.getHealthPoints());
    }

    /**
     * Method meant to be overwritten by the child classes. Used to receive the type of the hero.
     *
     * @return String value, representing the hero type.
     */
    abstract String getHeroType();

    /**
     * Method used to determine if the hero is alive or not.
     *
     * @return Boolean value proving information if the hero is alive or not.
     */
    public boolean isAlive() {
        return this.getHealthPoints() != 0;
    }

    /**
     * Getter method for the hero's health points.
     *
     * @return Integer value, representing the health points of the hero.
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Setter method for the hero's health points.
     *
     * @param healthPoints Integer value to be set as the health points of the hero.
     */
    void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Getter method for the hero's attack points.
     *
     * @return Integer value, representing the attack points of the hero.
     */
    int getAttackPoints() {
        return attackPoints;
    }

    /**
     * Setter method for the hero's attack points.
     *
     * @param attackPoints Integer value to be set as the attack points of the hero.
     */
    private void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    /**
     * Getter method for the hero's armor points.
     *
     * @return Integer value, representing the armor points of the hero.
     */
    public int getArmorPoints() {
        return armorPoints;
    }

    /**
     * Setter method for the hero's armor points.
     *
     * @param armorPoints Integer value to be set as the armor points of the hero.
     */
    private void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    /**
     * Getter method for the hero's name.
     *
     * @return String value, representing the name of the hero.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the hero's name.
     *
     * @param name String value to be set as the name of the hero.
     */
    private void setName(String name) {
        this.name = name;
    }
}
