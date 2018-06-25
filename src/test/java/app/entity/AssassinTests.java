package app.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssassinTests {
    private static final int ASSASSIN_CRITICAL_MULTIPLIER = 3;

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
