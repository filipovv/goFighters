package app.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

public class AssassinTests {
    private static final int ASSASSIN_CRITICAL_MULTIPLIER = 3;

    @Test
    public void testIfHeroIsInitialised() {
        //given
        Hero assassin = new Assassin("testName");
        String actualName = assassin.getName();
        //then
        assertEquals("Created hero name and expected does not match.", "testName", actualName);
    }

    @Test
    public void testIfSettingNullAsNameThrowsException() {
        try {
            Hero assassin = new Assassin(null);
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
            Hero assassin = new Assassin(name);
            fail("Expected exception did not occur. Name of hero cannot be empty.");
        } catch (IllegalArgumentException e) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }

    @Test
    public void testIfHeroIsKillable() {
        //given
        Hero assassin = new Assassin("testName");
        //when
        assassin.takeDamage(Integer.MAX_VALUE);
        //then
        assertFalse("Hero should be able to die.", assassin.isAlive());
    }

    @Test
    public void testIfAttackReturnsDamageValue() {
        //given
        Hero assassin = new Assassin("testName");
        int attackDamage = 0;
        //when
        attackDamage = assassin.attack();
        //then
        assertThat("Attack damage should be greater than 0.", attackDamage, greaterThan(0));
    }

    @Test
    public void testIfDamageTakenReturnsValue() {
        //given
        Hero assassin = new Assassin("testName");
        //when
        String takeDamageOutput = assassin.takeDamage(80);
        //then
        assertNotNull("Return value of method damageTaken() cannot be null.", takeDamageOutput);
    }

    @Test
    public void testIfGetHeroTypeMethodReturnsCorrectHeroType() {
        //given
        Hero assassin = new Assassin("testName");
        //when
        String actualHeroType = assassin.getHeroType();
        //then
        assertEquals("Incorrect return value of hero type Assassin.", "Assassin", actualHeroType);
    }

    @Test
    public void testIfCriticalOccur() {
        //given
        Hero assassin = new Assassin("testName");
        boolean isCritPossible = false;
        //when
        for (int i = 0; i < 100; i++) {
            int temp = assassin.attack();
            if (temp == assassin.getAttackPoints() * ASSASSIN_CRITICAL_MULTIPLIER) {
                isCritPossible = true;
                break;
            }
        }
        //then
        assertTrue("Assassin should be able to critically strike.", isCritPossible);
    }
}
