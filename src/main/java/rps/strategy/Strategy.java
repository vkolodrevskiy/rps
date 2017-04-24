package rps.strategy;

import rps.model.History;
import rps.model.Move;

/**
 * Next move selection strategy, based on player history.
 *
 * @author vkolodrevskiy
 */
public interface Strategy {
    Move getMove(History history);
}
