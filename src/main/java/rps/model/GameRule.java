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
     * @param robotMove robot move.
     * @param userMove user move.
     * @return {@code WIN} if robot wins user.
     */
    public GameResult play(Move robotMove, Move userMove) {
        if (robotMove == userMove) {
            return new GameResult(robotMove, userMove, GameResult.Status.TIE);
        } else if (robotMove.wins(userMove)) {
            return new GameResult(robotMove, userMove, GameResult.Status.WIN);
        } else {
            return new GameResult(robotMove, userMove, GameResult.Status.LOSS);
        }
    }
}
