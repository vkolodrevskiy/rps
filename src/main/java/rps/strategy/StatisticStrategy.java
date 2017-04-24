package rps.strategy;

import rps.model.History;
import rps.model.Move;

/**
 * Idea if the strategy is that most used move by the player will be chosen.
 *
 * @author vkolodrevskiy
 */
public class StatisticStrategy implements Strategy {
    @Override
    public Move getMove(History history) {
        return history.getMostCommonMove();
    }
}
