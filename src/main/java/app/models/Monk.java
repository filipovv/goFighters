package app.models;

public class Monk extends Hero {
    private static final int MONK_HEALTH_POINTS = 80;
    private static final int MONK_ATTACK_POINTS = 60;
    private static final int MONK_ARMOR_POINTS = 30;

    public Monk(String name) {
        super(name, MONK_HEALTH_POINTS, MONK_ATTACK_POINTS, MONK_ARMOR_POINTS);
    }

    @Override
    public String takeDamage(int damageTaken) {
        int generatedRandom = this.calculateRandomNumberFromBounds(1, 100);
        if (generatedRandom > 30) {
            this.setHealthPoints(this.getHealthPoints() - damageTaken);
            if (this.getHealthPoints() <= 0) {
                this.setHealthPoints(0);
                return String.format("Monk %s is dead.", this.getName());
            }
            return String.format("Monk %s took %d damage and is left with %d health points.", this.getName(), damageTaken, this.getHealthPoints());
        }
        return String.format("Monk %s successfully blocked the attack.", this.getName());
    }
}
