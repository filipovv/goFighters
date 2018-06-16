package app.models;

public class Warrior extends Hero {
    private static final int BASIC_HERO_HEALTH_POINTS = 1200;
    private static final int BASIC_HERO_ATTACK_POINTS = 60;
    private static final int BASIC_HERO_ARMOR_POINTS = 20;

    public Warrior(String name) {
        super(name, BASIC_HERO_HEALTH_POINTS, BASIC_HERO_ATTACK_POINTS, BASIC_HERO_ARMOR_POINTS);
    }

    @Override
    public String toString() {
        return String.format("Warrior with the following stats:%nHealth points - %d%nAttack points - %d%nArmor points - %d%n", BASIC_HERO_HEALTH_POINTS, BASIC_HERO_ATTACK_POINTS, BASIC_HERO_ARMOR_POINTS);
    }
}
