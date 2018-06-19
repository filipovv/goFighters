package app.models;

/**
 * Class Monk implements the properties and the functionality of a Monk type hero.
 * Derived class of Hero.class
 */
public class Monk extends Hero {
    private static final int MONK_HEALTH_POINTS = 800;
    private static final int MONK_ATTACK_POINTS = 80;
    private static final int MONK_ARMOR_POINTS = 30;
    private static final int BLOCK_CHANCE = 30;
    private static final String HERO_TYPE = "Monk";

    /**
     * Constructor for the Monk class. Uses the constructor from the base class.
     *
     * @param name This is the name of the hero.
     */
    public Monk(String name) {
        super(name, MONK_HEALTH_POINTS, MONK_ATTACK_POINTS, MONK_ARMOR_POINTS);
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
        if (generatedRandom > BLOCK_CHANCE) {
            return super.takeDamage(damageTaken);
        }
        return String.format("Monk %s successfully blocked the attack.", this.getName());
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

    /**
     * Method used to provide summed information about the object of type Knight.
     *
     * @return String value, representing the information about the object.
     */
    @Override
    public String toString() {
        return String.format("Monk with the following stats:%nHealth points - %d%nAttack points - %d%nArmor points - %d%n", MONK_HEALTH_POINTS, MONK_ATTACK_POINTS, MONK_ARMOR_POINTS);
    }
}
