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
     * Add player move to history.
     *
     * @param move
     */
    void add(Move move);

    /**
     * Retrieves most common player move.
     *
     * @return
     */
    Optional<Move> getMostCommonMove();

    /**
     * Retrieves most common move that was done after Markov Chains.
     *
     * @param patternLength Markov Chain pattern length.
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
