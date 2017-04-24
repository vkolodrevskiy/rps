package rps;

import rps.model.Move;

/**
 * Represents history of moves(e.g by human player or by program).
 * It's easy to represent it as {@code String}.
 * It may look like following sequence "prspprssprrsp".
 *
 * @author vkolodrevskiy
 */
public interface History {

    void add(Move move);
    Move getMostCommonMove();
}
