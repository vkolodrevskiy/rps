package rps;

import rps.model.GameResult;
import rps.model.GameRule;
import rps.model.History;
import rps.model.Move;
import rps.model.StringHistory;
import rps.strategy.StatisticStrategy;
import rps.strategy.StochasticStrategy;
import rps.strategy.Strategy;
import rps.strategy.StrategyRoulette;

/**
 * Handling game.
 *
 * @author vkolodrevskiy
 */
public class Game {
    private GameRule gameRule;
    private StrategyRoulette strategyRoulette;
    private History history;

    public Game() {
        gameRule = new GameRule();
        history = new StringHistory();

        strategyRoulette = new StrategyRoulette();
        strategyRoulette.addStrategy(new StatisticStrategy());
        strategyRoulette.addStrategy(new StochasticStrategy());
    }

    public GameResult playGameRound(Move userMove) {
        history.add(userMove);
        return gameRule.play(userMove, makeRobotMove());
    }

    private Move makeRobotMove() {
        Strategy strategy = strategyRoulette.getStrategy();
        return strategy.getMove(history);
    }
}
