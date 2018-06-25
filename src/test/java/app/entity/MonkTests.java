package app.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

public class MonkTests {
    private static final double LOWER_BOUND_FOR_DAMAGE_CALCULATION = 0.8;
    private static final double HIGHER_BOUND_FOR_DAMAGE_CALCULATION = 1.2;

    @Test
    public void testIfHeroIsInitialised() {
        //given
        Hero monk = new Monk("testName");
        String actualName = monk.getName();
        //then
        assertEquals("Created hero name and expected does not match.", "testName", actualName);
    }

    @Test
    public void testIfSettingNullAsNameThrowsException() {
        try {
            Hero monk = new Monk(null);
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
            Hero monk = new Monk(name);
            fail("Expected exception did not occur. Name of hero cannot be empty.");
        } catch (IllegalArgumentException e) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }

    @Test
    public void testIfAttackReturnsDamageValue() {
        //given
        Hero monk = new Monk("testName");
        int attackDamage = 0;
        //when
        attackDamage = monk.attack();
        //then
        assertThat("Attack damage should be greater than 0.", attackDamage, greaterThan(0));
    }

    @Test
    public void damageReturnedIsIntHeCorrectRange() {
        //given
        Hero monk = new Monk("testName");
        int actualDamage = monk.getAttackPoints();
        int lowerBound = (int) (actualDamage * LOWER_BOUND_FOR_DAMAGE_CALCULATION);
        int higherBound = (int) (actualDamage * HIGHER_BOUND_FOR_DAMAGE_CALCULATION);
        //when
        int damageAfterCalculation = monk.attack();
        //then
        assertTrue("Damage for Monk after calculation is not in the correct range.", lowerBound < damageAfterCalculation && damageAfterCalculation <= higherBound);
    }

    @Test
    public void testIfDamageTakenReturnsValue() {
        //given
        Hero monk = new Monk("testName");
        //when
        String takeDamageOutput = monk.takeDamage(80);
        //then
        assertNotNull("Return value of method damageTaken() cannot be null.", takeDamageOutput);
    }

    @Test
    public void testIfGetHeroTypeMethodReturnsCorrectHeroType() {
        //given
        Hero monk = new Monk("testName");
        String actualHeroType = monk.getHeroType();
        //then
        assertEquals("Incorrect return value of hero type Monk.", "Monk", actualHeroType);
    }

    @Test
    public void testIfBlockOccurs() {
        //given
        Hero monk = new Monk("testName");
        boolean isBlockPossible = false;
        //when
        for (int i = 0; i < 100; i++) {
            String temp = monk.takeDamage(40);
            if (temp.contains("successfully blocked")) {
                isBlockPossible = true;
                break;
            }
        }
        //then
        assertTrue("Monk should be able to block an upcoming attack.", isBlockPossible);
    }
}
