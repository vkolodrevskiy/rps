package rps.strategy;

import rps.model.History;
import rps.model.Move;

import java.util.Optional;

/**
 * Strategy based on Markov Chains.
 * Idea is that algorithm takes user last N moves(called pattern, identified by its length).
 * Then algorithm searches for appearance of that pattern in move history.
 * After that algorithm takes the most common move after given pattern.
 *
 * @author vkolodrevskiy
 */
public class MarkovChainStrategy implements Strategy {
    private static final byte PATTERN_LENGTH = 3;

    @Override
    public Move getMove(History history) {
        // if history is not long enough - return random move
        if (history.length() < PATTERN_LENGTH + 1) {
            return Move.randomMove();
        }

        Optional<Move> mostCommonMove = history.getMarkovChainMostCommonMove(PATTERN_LENGTH);
        return mostCommonMove.map(Move::findWinMoveAgainst).orElseGet(Move::randomMove);
    }
}
