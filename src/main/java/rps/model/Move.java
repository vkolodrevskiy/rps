package rps.model;

import java.util.Random;

/**
 * Represents move in the game.
 *
 * @author vkolodrevskiy
 */
public enum Move {
    Paper('p'),
    Rock('r'),
    Scissors('s');

    private final char code;
    private static final Move[] values = Move.values();
    private static final Random random = new Random();

    Move(char code) {
        this.code = code;
    }

    public char code() {
        return code;
    }

    public static Move randomMove() {
        return values[random.nextInt(values.length)];
    }

    /**
     * Determines whether move wins.
     *
     * @param arg next move.
     * @return true if given item wins.
     */
    public boolean wins(Move arg) {
        switch (this) {
            case Rock:
                return arg == Scissors;
            case Paper:
                return arg == Rock;
            case Scissors:
                return arg == Paper;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Get move to win given move.
     *
     * @return move that wins.
     */
    public static Move findWinMoveAgainst(Move move) {
        switch (move) {
            case Rock:
                return Paper;
            case Paper:
                return Scissors;
            case Scissors:
                return Rock;
            default: throw new IllegalArgumentException();
        }
    }

    public static Move valueOfCode(char c) {
        switch (c) {
            case 'r':
            case 'R':
                return Rock;
            case 'p':
            case 'P':
                return Paper;
            case 's':
            case 'S':
                return Scissors;
            default: throw new IllegalArgumentException();
        }
    }
}
