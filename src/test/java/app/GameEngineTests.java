package app;

import app.entity.Assassin;
import app.entity.Hero;
import app.entity.Monk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class GameEngineTests {
    private Hero firstHero;
    private Hero secondHero;

    @Before
    public void setUp() {
        this.firstHero = new Assassin("firstTestHero");
        this.secondHero = new Monk("secondTestHero");
    }

    @Test
    public void testIfAddingNullPlayerThrowsException() {
        try {
            GameEngine gameEngine = new GameEngine(firstHero, null);
            fail("Expected exception did not occur. Hero in game engine cannot be null.");
        } catch (IllegalArgumentException iae) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }

    @Test
    public void testIfFightMethodReturnsFightLog() {
        //given
        GameEngine gameEngine = new GameEngine(firstHero, secondHero);
        //when
        String gameLog = gameEngine.fight();
        //then
        assertNotNull("Fight method in the Game Engine should return a game log.", gameLog);
        assertFalse("Fight log returned from fight method in Game Engine should not be empty.", gameLog.isEmpty());
    }

    @Test
    public void testIfAddingOneHeroAsBothHeroesInTheGameEngine() {
        try {
            GameEngine gameEngine = new GameEngine(firstHero, firstHero);
            fail("Expected exception did not occur. Second hero in game engine cannot be the same as the first one.");
        } catch (IllegalArgumentException iea) {
            //If this block is reached there is no need for the exception to be handled.
        }
    }
}
