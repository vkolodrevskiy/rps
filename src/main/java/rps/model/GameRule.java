package rps.model;

/**
 * Represents rules of the game.
 *
 * @author vkolodrevskiy
 */
public class GameRule {
    /**
     * Play game between robot and user.
     *
     * @param userMove user move.
     * @param robotMove robot move.
     * @return {@code WIN} if robot wins user.
     */
    public GameResult play(Move userMove, Move robotMove) {
        if (userMove == robotMove) {
            return new GameResult(userMove, robotMove, GameResult.Status.TIE);
        } else if (userMove.wins(robotMove)) {
            return new GameResult(userMove, robotMove, GameResult.Status.WIN);
        } else {
            return new GameResult(userMove, robotMove, GameResult.Status.LOSS);
        }
    }
}
