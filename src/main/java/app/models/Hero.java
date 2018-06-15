package app.models;


import java.util.Random;

public abstract class Hero {
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

    int calculateRandomNumberFromBounds(int lowerBound, int higherBound) {
        Random random = new Random();
        return random.nextInt(higherBound - lowerBound) + lowerBound;
    }

    public int attack() {
        int lowerBound = (int) (this.getAttackPoints() * 0.8);
        int higherBound = (int) (this.getAttackPoints() * 1.2);
        return this.calculateRandomNumberFromBounds(lowerBound, higherBound);
    }

    public String takeDamage(int damageTaken) {
        int lowerBound = (int) (this.getArmorPoints() * 0.8);
        int higherBound = (int) (this.getArmorPoints() * 1.2);
        int shieldPoints = this.calculateRandomNumberFromBounds(lowerBound, higherBound);

        int healthPointsTaken = damageTaken - shieldPoints;

        this.setHealthPoints(this.getHealthPoints() - healthPointsTaken);
        if (this.getHealthPoints() <= 0) {
            this.setHealthPoints(0);
            return String.format("Hero %s is dead.", this.getName());
        }
        return String.format("Hero %s took %d damage and is left with %d health points.", this.getName(), healthPointsTaken, this.getHealthPoints());
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

    public void setName(String name) {
        this.name = name;
    }
}
