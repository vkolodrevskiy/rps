package rps.model;

import java.util.Optional;

/**
 * Represents history of moves(e.g by human player or by program).
 * It's easy to represent it as {@code String}.
 * It may look like following sequence "prspprssprrsp".
 *
 * @author vkolodrevskiy
 */
public interface History {

    /**
     * Add user move to history.
     *
     * @param move
     */
    void add(Move move);

    /**
     * Retrieves most common user move.
     *
     * @return
     */
    Move getMostCommonMove();

    /**
     *
     * @param patternLength
     * @return
     */
    Optional<Move> getMarkovChainMostCommonMove(byte patternLength);

    /**
     * Length of the history.
     *
     * @return
     */
    Integer length();
}
