package app.models;

/**
 * Class Assassin implements the properties and the functionality of a Assassin type hero.
 * Derived class of Hero.class
 */
public class Assassin extends Hero {
    private static final int ASSASSIN_HEALTH_POINTS = 700;
    private static final int ASSASSIN_ATTACK_POINTS = 80;
    private static final int ASSASSIN_ARMOR_POINTS = 10;
    private static final int ATTACK_CRITICAL_CHANCE = 30;
    private static final int ATTACK_CRITICAL_MULTIPLIER = 3;
    private static final String HERO_TYPE = "Assassin";

    /**
     * Constructor for the Assassin class. Uses the constructor from the base class.
     *
     * @param name This is the name of the hero.
     */
    public Assassin(String name) {
        super(name, ASSASSIN_HEALTH_POINTS, ASSASSIN_ATTACK_POINTS, ASSASSIN_ARMOR_POINTS);
    }

    /**
     * Method used to add some functionality over the base method.
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
        return String.format("Assassin with the following stats:%nHealth points - %d%nAttack points - %d%nArmor points - %d%n", ASSASSIN_HEALTH_POINTS, ASSASSIN_ATTACK_POINTS, ASSASSIN_ARMOR_POINTS);
    }
}
