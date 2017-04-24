package rps;

import rps.model.Move;

import java.util.EnumMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        Game game = new Game();

        Map<Move, Integer> map = new EnumMap<>(Move.class);


        new Cli(game).start();
    }
}
