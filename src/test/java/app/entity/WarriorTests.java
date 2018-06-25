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
        //given
        Hero warrior = new Warrior("testName");
        String actualHeroName = warrior.getName();
        //then
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
            //given
            String name = "";
            //then
            Hero warrior = new Warrior(name);
            fail("Expected exception did not occur. Name of hero cannot be empty.");
        } catch (IllegalArgumentException e) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }

    @Test
    public void testIfHeroIsKillable() {
        Hero warrior = new Warrior("testName");
        //when
        warrior.takeDamage(Integer.MAX_VALUE);
        //then
        assertFalse("Hero should be able to die.", warrior.isAlive());
    }

    @Test
    public void testIfAttackReturnsDamageValue() {
        Hero warrior = new Warrior("testName");
        //given
        int attackDamage = 0;
        //when
        attackDamage = warrior.attack();
        //then
        assertThat("Attack damage should be greater than 0.", attackDamage, greaterThan(0));
    }

    @Test
    public void damageReturnedIsIntHeCorrectRange() {
        //given
        Hero warrior = new Warrior("testName");
        int actualDamage = warrior.getAttackPoints();
        int lowerBound = (int) (actualDamage * LOWER_BOUND_FOR_DAMAGE_CALCULATION);
        int higherBound = (int) (actualDamage * HIGHER_BOUND_FOR_DAMAGE_CALCULATION);
        //when
        int damageAfterCalculation = warrior.attack();
        //then
        assertTrue("Damage for Warrior after calculation is not in the correct range.", lowerBound < damageAfterCalculation && damageAfterCalculation <= higherBound);
    }

    @Test
    public void testIfDamageTakenReturnsValue() {
        //given
        Hero warrior = new Warrior("testName");
        //when
        String takeDamageOutput = warrior.takeDamage(80);
        //then
        assertNotNull("Return value of method damageTaken() cannot be null.", takeDamageOutput);
    }

    @Test
    public void testIfGetHeroTypeMethodReturnsCorrectHeroType() {
        //given
        Hero warrior = new Warrior("testName");
        String actualHeroType = warrior.getHeroType();
        //then
        assertEquals("Incorrect return value of hero type Warrior.", "Warrior", actualHeroType);
    }
}
