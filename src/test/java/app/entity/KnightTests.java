package app.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTests {
    private static final int KNIGHT_CRITICAL_MULTIPLIER = 2;

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
