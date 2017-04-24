package rps.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link GameRule} tests.
 *
 * @author vkolodrevskiy
 */
public class GameRuleTest {
    @Test
    public void play() throws Exception {
        GameRule gameRule = new GameRule();

        assertEquals(GameResult.Status.TIE, gameRule.play(Move.Paper, Move.Paper).getStatus());
        assertEquals(GameResult.Status.TIE, gameRule.play(Move.Rock, Move.Rock).getStatus());
        assertEquals(GameResult.Status.TIE, gameRule.play(Move.Scissors, Move.Scissors).getStatus());

        assertEquals(GameResult.Status.WIN, gameRule.play(Move.Paper, Move.Rock).getStatus());
        assertEquals(GameResult.Status.WIN, gameRule.play(Move.Rock, Move.Scissors).getStatus());
        assertEquals(GameResult.Status.WIN, gameRule.play(Move.Scissors, Move.Paper).getStatus());

        assertEquals(GameResult.Status.LOSS, gameRule.play(Move.Paper, Move.Scissors).getStatus());
        assertEquals(GameResult.Status.LOSS, gameRule.play(Move.Rock, Move.Paper).getStatus());
        assertEquals(GameResult.Status.LOSS, gameRule.play(Move.Scissors, Move.Rock).getStatus());
    }
}
