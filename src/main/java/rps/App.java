package rps;

/**
 * Program main entry point.
 */
public class App {

    public static void main(String[] args) {
        Game game = new Game();
        new Cli(game).start();
    }
}
