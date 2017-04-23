package rps.strategy;

import rps.History;
import rps.Move;

/**
 * Next move selection strategy, based on player history.
 *
 * @author vkolodrevskiy
 */
public interface Strategy {
    Move getMove(History history);
}
