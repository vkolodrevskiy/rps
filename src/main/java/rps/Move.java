package rps;

/**
 * TODO: add description.
 *
 * @author vkolodrevskiy
 */
public enum Move {
    Paper('p'),
    Rock('r'),
    Scissors('s');

    private final char code;

    Move(char code) {
        this.code = code;
    }

    public char code() {
        return code;
    }

    /**
     * Determines whether move wins.
     * @param arg next move.
     * @return true if given item wins.
     */
    boolean wins(Move arg) {
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
     *
     * @return move that wins userTake
     */
    public static Move findWinMoveAgainst(Move userTake) {
        switch (userTake) {
            case Rock:
                return Paper;
            case Paper:
                return Scissors;
            case Scissors:
                return Rock;
        }
        throw new IllegalArgumentException();
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
        }
        throw new IllegalArgumentException();
    }
}
