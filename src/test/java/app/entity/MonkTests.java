package app.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonkTests {

    @Test
    public void testIfGetHeroTypeMethodReturnsCorrectHeroType() {
        // Given
        Hero monk = new Monk("testName");

        // When
        String actualHeroType = monk.getHeroType();

        // Then
        assertEquals("Incorrect return value of hero type Monk.", "Monk", actualHeroType);
    }

    @Test
    public void testIfBlockOccurs() {
        // Given
        Hero monk = new Monk("testName");
        boolean isBlockPossible = false;

        // When
        for (int i = 0; i < 100; i++) {
            String temp = monk.takeDamage(40);
            if (temp.contains("successfully blocked")) {
                isBlockPossible = true;
                break;
            }
        }

        // Then
        assertTrue("Monk should be able to block an upcoming attack.", isBlockPossible);
    }
}
