package rps;

import rps.model.GameResult;
import rps.model.GameRule;
import rps.model.Move;

/**
 * TODO: add description.
 *
 * @author vkolodrevskiy
 */
public class Game {
    private GameRule gameRule = new GameRule();

    public Game() {
    }

    private Move makeComputerMove() {
        return Move.Paper;
    }

    public GameResult playGameRound() {



        return gameRule.play(null, null);
    }
}
