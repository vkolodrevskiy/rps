package rps.strategy;

import rps.History;
import rps.model.Move;

/**
 * Idea of the strategy is that move is selected randomly.
 *
 * @author vkolodrevskiy
 */
public class StochasticStrategy implements Strategy {
    public Move getMove(History history) {
        return Move.randomMove();
    }
}
