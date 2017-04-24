package rps.model;

/**
 * Represents game round result.
 *
 * @author vkolodrevskiy
 */
public class GameResult {
    private Move robotMove;
    private Move userMove;
    private Status status;

    public GameResult(Move robotMove, Move userMove, Status status) {
        this.robotMove = robotMove;
        this.userMove = userMove;
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
