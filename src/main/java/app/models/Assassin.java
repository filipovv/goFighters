package app.models;

public class Assassin extends Hero {
    private static final int ASSASSIN_HEALTH_POINTS = 80;
    private static final int ASSASSIN_ATTACK_POINTS = 80;
    private static final int ASSASSIN_ARMOR_POINTS = 10;

    public Assassin(String name) {
        super(name, ASSASSIN_HEALTH_POINTS, ASSASSIN_ATTACK_POINTS, ASSASSIN_ARMOR_POINTS);
    }

    @Override
    public int attack() {
        int generatedRandom = this.calculateRandomNumberFromBounds(1, 100);
        if (generatedRandom <= 30) {
            return (this.getAttackPoints() * 3);
        }
        return super.attack();
    }
}
