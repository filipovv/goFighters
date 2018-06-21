package app.entity;

/**
 * Class Knight implements the properties and the functionality of a Knight type hero.
 * Derived class of Hero.class
 */
public class Knight extends Hero {
    private static final int KNIGHT_HEALTH_POINTS = 1000;
    private static final int KNIGHT_ATTACK_POINTS = 70;
    private static final int KNIGHT_ARMOR_POINTS = 40;
    private static final int ATTACK_CRITICAL_CHANCE = 10;
    private static final int ATTACK_CRITICAL_MULTIPLIER = 2;
    private static final int BLOCK_CHANCE = 20;
    private static final String HERO_TYPE = "Knight";

    /**
     * Constructor for the Knight class. Uses the constructor from the base class.
     *
     * @param name This is the name of the hero.
     */
    public Knight(String name) {
        super(name, KNIGHT_HEALTH_POINTS, KNIGHT_ATTACK_POINTS, KNIGHT_ARMOR_POINTS);
    }

    /**
     * Method used to add some functionality and dependency for the base method.
     *
     * @return Integer value, representing the attack force of the hero in his current attack.
     */
    @Override
    public int attack() {
        int generatedRandom = this.generateRandomNumberForChanceCalculation();
        if (generatedRandom <= ATTACK_CRITICAL_CHANCE) {
            return (this.getAttackPoints() * ATTACK_CRITICAL_MULTIPLIER);
        }
        return super.attack();
    }

    /**
     * Method used to add some functionality over the base method.
     *
     * @param damageTaken The damage received from the enemy attack
     * @return String value, representing the outcome of the received attack.
     */
    @Override
    public String takeDamage(int damageTaken) {
        int generatedRandom = this.generateRandomNumberForChanceCalculation();
        if (generatedRandom <= BLOCK_CHANCE) {
            return String.format("Knight %s successfully blocked the attack.", this.getName());
        }
        return super.takeDamage(damageTaken);
    }

    /**
     * Method used to return the type of the hero.
     *
     * @return String value, representing the hero type.
     */
    @Override
    String getHeroType() {
        return HERO_TYPE;
    }
}
