package app.models;


import java.util.Random;

public abstract class Hero {
    private static final double ATTACK_LOWER_BOUND_MULTIPLIER = 0.8;
    private static final double ATTACK_HIGHER_BOUND_MULTIPLIER = 1.2;
    private static final double DEFENCE_LOWER_BOUND_MULTIPLIER = 0.8;
    private static final double DEFENCE_HIGHER_BOUND_MULTIPLIER = 1.2;

    private String name;
    private int healthPoints;
    private int attackPoints;
    private int armorPoints;

    Hero(String name, int healthPoints, int attackPoints, int armorPoints) {
        this.setName(name);
        this.setHealthPoints(healthPoints);
        this.setAttackPoints(attackPoints);
        this.setArmorPoints(armorPoints);
    }

    int generateRandomNumberForChanceCalculation() {
        return this.calculateRandomNumberFromBounds(1, 100);
    }

    int calculateRandomNumberFromBounds(int lowerBound, int higherBound) {
        Random random = new Random();
        return random.nextInt(higherBound - lowerBound) + lowerBound;
    }

    public int attack() {
        int lowerBound = (int) (this.getAttackPoints() * ATTACK_LOWER_BOUND_MULTIPLIER);
        int higherBound = (int) (this.getAttackPoints() * ATTACK_HIGHER_BOUND_MULTIPLIER);
        return this.calculateRandomNumberFromBounds(lowerBound, higherBound);
    }

    public String takeDamage(int damageTaken) {
        int lowerBound = (int) (this.getArmorPoints() * DEFENCE_LOWER_BOUND_MULTIPLIER);
        int higherBound = (int) (this.getArmorPoints() * DEFENCE_HIGHER_BOUND_MULTIPLIER);
        int shieldPoints = this.calculateRandomNumberFromBounds(lowerBound, higherBound);

        int healthPointsTaken = damageTaken - shieldPoints;

        this.setHealthPoints(this.getHealthPoints() - healthPointsTaken);
        if (this.getHealthPoints() <= 0) {
            this.setHealthPoints(0);
            return String.format("Hero %s is dead.", this.getName());
        }
        return String.format("%s %s took %d damage and is left with %d health points.", this.getHeroType(), this.getName(), healthPointsTaken, this.getHealthPoints());
    }

    private String getHeroType() {
        return this.getClass().getSimpleName();
    }

    public boolean isAlive() {
        return this.getHealthPoints() != 0;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    private void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    private void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
