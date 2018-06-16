package app.models;

public class Knight extends Hero {
    private static final int KNIGHT_HEALTH_POINTS = 1000;
    private static final int KNIGHT_ATTACK_POINTS = 70;
    private static final int KNIGHT_ARMOR_POINTS = 40;
    private static final int ATTACK_CRITICAL_CHANCE = 10;
    private static final int ATTACK_CRITICAL_MULTIPLIER = 2;
    private static final int BLOCK_CHANCE = 20;

    public Knight(String name) {
        super(name, KNIGHT_HEALTH_POINTS, KNIGHT_ATTACK_POINTS, KNIGHT_ARMOR_POINTS);
    }

    @Override
    public String takeDamage(int damageTaken) {
        int generatedRandom = this.generateRandomNumberForChanceCalculation();
        if (generatedRandom > BLOCK_CHANCE) {
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
        int generatedRandom = this.generateRandomNumberForChanceCalculation();
        if (generatedRandom <= ATTACK_CRITICAL_CHANCE) {
            return (this.getAttackPoints() * ATTACK_CRITICAL_MULTIPLIER);
        }
        return super.attack();
    }

    @Override
    public String toString() {
        return String.format("Knight with the following stats:%nHealth points - %d%nAttack points - %d%nArmor points - %d%n", KNIGHT_HEALTH_POINTS, KNIGHT_ATTACK_POINTS, KNIGHT_ARMOR_POINTS);
    }
}
