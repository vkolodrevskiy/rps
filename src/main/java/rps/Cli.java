package rps;

import rps.model.GameResult;
import rps.model.Move;

import java.util.Scanner;

/**
 * Game command line interface.
 *
 * @author vkolodrevskiy
 */
public class Cli {
    private final Game game;

    public Cli(Game game) {
        this.game = game;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        printHelp();
        String input;

        do {
            System.out.print("[R, P, S]: ");
            input = scanner.nextLine();
            if (input != null && ! input.trim().isEmpty() && "R|P|S|r|p|s".contains(input)) {
                GameResult gameResult = game.playGameRound(Move.valueOfCode(input.charAt(0)));
                System.out.println(String.format("Computer move was: %s, you: %s!",
                        gameResult.getRobotMove(), gameResult.getStatus()));
            }
        } while (!("E".equalsIgnoreCase(input)));
    }

    private void printHelp() {
        System.out.println("Usage:");
        System.out.println("E, e\t-\t to exit;");;
        System.out.println("R, r\t-\t for rock;");
        System.out.println("P, p\t-\t for paper;");
        System.out.println("S, s\t-\t for scissors.");
        System.out.println("\n\nPlease enter your move.");
    }
}
