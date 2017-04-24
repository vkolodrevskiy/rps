package rps;

import rps.model.GameResult;
import rps.model.GameRule;
import rps.model.History;
import rps.model.Move;
import rps.model.StringHistory;
import rps.strategy.MarkovChainStrategy;
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
    private final GameRule gameRule;
    private final StrategyRoulette strategyRoulette;
    private final History userHistory;

    public Game() {
        gameRule = new GameRule();
        userHistory = new StringHistory();

        strategyRoulette = new StrategyRoulette();
        strategyRoulette.addStrategy(new StatisticStrategy());
        strategyRoulette.addStrategy(new StochasticStrategy());
        strategyRoulette.addStrategy(new MarkovChainStrategy());
    }

    public GameResult playGameRound(Move userMove) {
        userHistory.add(userMove);
        return gameRule.play(userMove, makeRobotMove());
    }

    private Move makeRobotMove() {
        Strategy strategy = strategyRoulette.getStrategy();
        return strategy.getMove(userHistory);
    }
}
