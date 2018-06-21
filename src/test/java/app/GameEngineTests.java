package app;

import app.entity.Assassin;
import app.entity.Hero;
import app.entity.Monk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class GameEngineTests {
    private Hero firstHero;
    private Hero secondHero;

    @Before
    public void setUp() {
        this.firstHero = new Assassin("firstTestHero");
        this.secondHero = new Monk("secondTestHero");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfAddingNullPlayerThrowsException() {
        GameEngine gameEngine = new GameEngine(firstHero, null);
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

    @Test(expected = IllegalArgumentException.class)
    public void testIfAddingOneHeroAsBothHeroesInTheGameEngine() {
        GameEngine gameEngine = new GameEngine(firstHero, firstHero);
    }
}
