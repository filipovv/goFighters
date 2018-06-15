package app.models;

public class Knight extends Hero {
    private static final int KNIGHT_HEALTH_POINTS = 150;
    private static final int KNIGHT_ATTACK_POINTS = 60;
    private static final int KNIGHT_ARMOR_POINTS = 30;

    public Knight(String name) {
        super(name, KNIGHT_HEALTH_POINTS, KNIGHT_ATTACK_POINTS, KNIGHT_ARMOR_POINTS);
    }

    @Override
    public String takeDamage(int damageTaken) {
        int generatedRandom = this.calculateRandomNumberFromBounds(1, 100);
        if (generatedRandom > 20) {
            this.setHealthPoints(this.getHealthPoints() - damageTaken);
            if (this.getHealthPoints() <= 0) {
                this.setHealthPoints(0);
                return String.format("Knight %s is dead.", this.getName());
            }
            return String.format("Knight %s took %d damage and is left with %d health points.", this.getName(), damageTaken, this.getHealthPoints());
        }
        return String.format("Knight %s successfully blocked the attack.", this.getName());
    }

    @Override
    public int attack() {
        int generatedRandom = this.calculateRandomNumberFromBounds(1, 100);
        if (generatedRandom <= 10) {
            return (this.getAttackPoints() * 2);
        }
        return super.attack();
    }
}
