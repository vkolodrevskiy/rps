package rps.model;

/**
 * Represents game round result.
 *
 * @author vkolodrevskiy
 */
public class GameResult {
    private final Move userMove;
    private final Move robotMove;
    private final Status status;

    public GameResult(Move userMove, Move robotMove, Status status) {
        this.userMove = userMove;
        this.robotMove = robotMove;
        this.status = status;
    }

    public Move getRobotMove() {
        return robotMove;
    }

    public Move getUserMove() {
        return userMove;
    }

    public Status getStatus() {
        return status;
    }

    enum Status {
        WIN,
        LOSS,
        TIE
    }
}
