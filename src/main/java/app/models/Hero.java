package app.models;


import java.util.Random;

/**
 * Base class Hero used to provide basic functionality and properties to all classes that inherit it.
 */
public abstract class Hero {
    private static final double ATTACK_DEFENCE_LOWER_BOUND_MULTIPLIER = 0.8;
    private static final double ATTACK_DEFENCE_HIGHER_BOUND_MULTIPLIER = 1.2;

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
    private int calculateRandomNumberFromBounds(int lowerBound, int higherBound) {
        Random random = new Random();
        return random.nextInt((higherBound - lowerBound) + 1) + lowerBound;
    }

    /**
     * Method used to calculate and simulate the attack action of the hero
     *
     * @return Integer value, representing the attack force of the hero in his current attack.
     */
    public int attack() {
        int lowerBound = (int) (this.getAttackPoints() * ATTACK_DEFENCE_LOWER_BOUND_MULTIPLIER);
        int higherBound = (int) (this.getAttackPoints() * ATTACK_DEFENCE_HIGHER_BOUND_MULTIPLIER);
        return this.calculateRandomNumberFromBounds(lowerBound, higherBound);
    }

    /**
     * Method used to calculate and simulate the defence of the hero
     *
     * @param damageTaken The damage received from the enemy attack
     * @return String value, representing the outcome of the received attack.
     */
    public String takeDamage(int damageTaken) {
        int lowerBound = (int) (this.getArmorPoints() * ATTACK_DEFENCE_LOWER_BOUND_MULTIPLIER);
        int higherBound = (int) (this.getArmorPoints() * ATTACK_DEFENCE_HIGHER_BOUND_MULTIPLIER);
        int shieldPoints = this.calculateRandomNumberFromBounds(lowerBound, higherBound);

        int healthPointsTaken = damageTaken - shieldPoints;
        if (healthPointsTaken > 0) {
            this.setHealthPoints(this.getHealthPoints() - healthPointsTaken);
            if (this.getHealthPoints() <= 0) {
                this.setHealthPoints(0);
                return String.format("%s %s is dead.", this.getHeroType(), this.getName());
            }
            return String.format("%s %s took %d damage and is left with %d health points.",
                    this.getHeroType(), this.getName(), healthPointsTaken, this.getHealthPoints());
        } else {
            return String.format("Attack was too weak and %s %s took no damage from it.", this.getHeroType(), this.getName());
        }
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

    @Override
    public String toString() {
        return String.format("%s with the following stats:%nHealth points - %d%nAttack points - %d%nArmor points - %d%n",
                this.getHeroType(), this.getHealthPoints(), this.getAttackPoints(), this.getArmorPoints());
    }

    /**
     * Getter method for the hero's health points.
     *
     * @return Integer value, representing the health points of the hero.
     */
    private int getHealthPoints() {
        return this.healthPoints;
    }

    /**
     * Setter method for the hero's health points.
     *
     * @param healthPoints Integer value to be set as the health points of the hero.
     */
    private void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Getter method for the hero's attack points.
     *
     * @return Integer value, representing the attack points of the hero.
     */
    int getAttackPoints() {
        return this.attackPoints;
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
    private int getArmorPoints() {
        return this.armorPoints;
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
        return this.name;
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
