package app.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

public class WarriorTests {
    private static final double LOWER_BOUND_FOR_DAMAGE_CALCULATION = 0.8;
    private static final double HIGHER_BOUND_FOR_DAMAGE_CALCULATION = 1.2;

    @Test
    public void testIfHeroIsInitialised() {
        // Given
        Hero warrior = new Warrior("testName");

        // When
        String actualHeroName = warrior.getName();

        // Then
        assertEquals("Created hero name and expected does not match.", "testName", actualHeroName);
    }

    @Test
    public void testIfSettingNullAsNameThrowsException() {
        try {
            Hero warrior = new Warrior(null);
            fail("Expected exception did not occur. Name of hero cannot be null.");
        } catch (IllegalArgumentException e) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }

    @Test
    public void testIfSettingEmptyStringAsNameThrowsException() {
        try {
            // Given
            String name = "";

            // Then
            Hero warrior = new Warrior(name);
            fail("Expected exception did not occur. Name of hero cannot be empty.");
        } catch (IllegalArgumentException e) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }

    @Test
    public void testIfHeroIsKillable() {
        // Given
        Hero warrior = new Warrior("testName");

        // When
        warrior.takeDamage(Integer.MAX_VALUE);

        // Then
        assertFalse("Hero should be able to die.", warrior.isAlive());
    }

    @Test
    public void testIfAttackReturnsDamageValue() {
        // Given
        Hero warrior = new Warrior("testName");
        int attackDamage = 0;

        // When
        attackDamage = warrior.attack();

        // Then
        assertThat("Attack damage should be greater than 0.", attackDamage, greaterThan(0));
    }

    @Test
    public void testIfDamageReturnedIsInTheCorrectRange() {
        // Given
        Hero warrior = new Warrior("testName");
        int actualDamage = warrior.getAttackPoints();
        int lowerBound = (int) (actualDamage * LOWER_BOUND_FOR_DAMAGE_CALCULATION);
        int higherBound = (int) (actualDamage * HIGHER_BOUND_FOR_DAMAGE_CALCULATION);

        // When
        int damageAfterCalculation = warrior.attack();

        // Then
        assertTrue("Damage for Warrior after calculation is not in the correct range.", lowerBound <= damageAfterCalculation && damageAfterCalculation <= higherBound);
    }

    @Test
    public void testIfDamageTakenReturnsValue() {
        // Given
        Hero warrior = new Warrior("testName");

        // When
        String takeDamageOutput = warrior.takeDamage(80);

        // Then
        assertNotNull("Return value of method damageTaken() cannot be null.", takeDamageOutput);
    }

    @Test
    public void testIfGetHeroTypeMethodReturnsCorrectHeroType() {
        // Given
        Hero warrior = new Warrior("testName");

        // When
        String actualHeroType = warrior.getHeroType();

        // Then
        assertEquals("Incorrect return value of hero type Warrior.", "Warrior", actualHeroType);
    }
}
