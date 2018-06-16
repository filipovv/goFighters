package app.models;

public class Assassin extends Hero {
    private static final int ASSASSIN_HEALTH_POINTS = 700;
    private static final int ASSASSIN_ATTACK_POINTS = 80;
    private static final int ASSASSIN_ARMOR_POINTS = 10;
    private static final int ATTACK_CRITICAL_CHANCE = 30;
    private static final int ATTACK_CRITICAL_MULTIPLIER = 3;

    public Assassin(String name) {
        super(name, ASSASSIN_HEALTH_POINTS, ASSASSIN_ATTACK_POINTS, ASSASSIN_ARMOR_POINTS);
    }

    @Override
    public int attack() {
        int generatedRandom = this.generateRandomNumberForChanceCalculation();
        if (generatedRandom <= ATTACK_CRITICAL_CHANCE) {
            return (this.getAttackPoints() * ATTACK_CRITICAL_MULTIPLIER);
        }
        return super.attack();
    }

    @Override
    public String toString() {
        return String.format("Assassin with the following stats:%nHealth points - %d%nAttack points - %d%nArmor points - %d%n", ASSASSIN_HEALTH_POINTS, ASSASSIN_ATTACK_POINTS, ASSASSIN_ARMOR_POINTS);
    }
}
