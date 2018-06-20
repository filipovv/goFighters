package app.models;

/**
 * Class Warrior implements the properties and the functionality of a Warrior type hero.
 * Derived class of Hero.class
 */
public class Warrior extends Hero {
    private static final int BASIC_HERO_HEALTH_POINTS = 1200;
    private static final int BASIC_HERO_ATTACK_POINTS = 60;
    private static final int BASIC_HERO_ARMOR_POINTS = 20;
    private static final String HERO_TYPE = "Warrior";

    /**
     * Constructor for the Warrior class. Uses the constructor from the base class.
     *
     * @param name This is the name of the hero.
     */
    public Warrior(String name) {
        super(name, BASIC_HERO_HEALTH_POINTS, BASIC_HERO_ATTACK_POINTS, BASIC_HERO_ARMOR_POINTS);
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
