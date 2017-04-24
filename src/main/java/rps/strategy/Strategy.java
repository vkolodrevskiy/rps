package rps.strategy;

import rps.model.History;
import rps.model.Move;

/**
 * Next move selection strategy.
 *
 * @author vkolodrevskiy
 */
public interface Strategy {
    /**
     * Return next move for the given opponent history of moves.
     *
     * @param history opponent history of moves.
     * @return move to win the round.
     */
    Move getMove(History history);
}
