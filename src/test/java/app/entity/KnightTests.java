package app.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

public class KnightTests {
    private static final int KNIGHT_CRITICAL_MULTIPLIER = 2;

    @Test
    public void testIfHeroIsInitialised() {
        //given
        Hero knight = new Knight("testName");
        //when
        String actualName = knight.getName();
        //then
        assertEquals("Created hero name and expected does not match.", "testName", actualName);
    }

    @Test
    public void testIfSettingNullAsNameThrowsException() {
        try {
            Hero knight = new Knight(null);
            fail("Expected exception did not occur.");
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
            Hero knight = new Knight(name);
            fail("Expected exception did not occur.");
        } catch (IllegalArgumentException e) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }

    @Test
    public void testIfAttackReturnsDamageValue() {
        //given
        Hero knight = new Knight("testName");
        int attackDamage = 0;
        //when
        attackDamage = knight.attack();
        //then
        assertThat("Damage should be greater than 0.", attackDamage, greaterThan(0));
    }

    @Test
    public void testIfDamageTakenReturnsValue() {
        //given
        Hero knight = new Knight("testName");
        //when
        String takeDamageOutput = knight.takeDamage(80);
        //then
        assertNotNull("Return value of method damageTaken() cannot be null.", takeDamageOutput);
    }

    @Test
    public void testIfGetHeroTypeMethodReturnsCorrectHeroType() {
        //given
        Hero knight = new Knight("testName");
        //when
        String actualHeroType = knight.getHeroType();
        //then
        assertEquals("Incorrect return value of hero type Knight.", "Knight", actualHeroType);
    }

    @Test
    public void testIfCriticalOccurs() {
        //given
        Hero knight = new Knight("testName");
        boolean isCritPossible = false;
        //when
        for (int i = 0; i < 100; i++) {
            int temp = knight.attack();
            if (temp == knight.getAttackPoints() * KNIGHT_CRITICAL_MULTIPLIER) {
                isCritPossible = true;
                break;
            }
        }
        //then
        assertTrue("Knight should be able to critically strike.", isCritPossible);
    }

    @Test
    public void testIfBlockOccurs() {
        //given
        Hero knight = new Knight("testName");
        boolean isBlockPossible = false;
        //when
        for (int i = 0; i < 100; i++) {
            String temp = knight.takeDamage(50);
            if (temp.contains("successfully blocked")) {
                isBlockPossible = true;
                break;
            }
        }
        //then
        assertTrue("Knight should be able to block an upcoming attack.", isBlockPossible);
    }

}
