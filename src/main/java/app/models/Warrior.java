package app.models;

public class Warrior extends Hero {
    private static final int BASIC_HERO_HEALTH_POINTS = 100;
    private static final int BASIC_HERO_ATTACK_POINTS = 50;
    private static final int BASIC_HERO_ARMOR_POINTS = 20;

    public Warrior(String name) {
        super(name, BASIC_HERO_HEALTH_POINTS, BASIC_HERO_ATTACK_POINTS, BASIC_HERO_ARMOR_POINTS);
    }
}
