package rps.strategy;

import rps.model.History;
import rps.model.Move;

/**
 * Idea of the strategy is that move is selected randomly.
 *
 * @author vkolodrevskiy
 */
public class StochasticStrategy implements Strategy {
    @Override
    public Move getMove(History history) {
        return Move.randomMove();
    }
}
