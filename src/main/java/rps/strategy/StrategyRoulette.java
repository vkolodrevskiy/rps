package rps.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Selecting strategy for the move.
 *
 * @author vkolodrevskiy
 */
public class StrategyRoulette {
    private List<Strategy> strategies;
    private Random random = new Random();

    public StrategyRoulette() {
        this.strategies = new ArrayList<>(5);
    }

    public void addStrategy(Strategy strategy) {
        this.strategies.add(strategy);
    }

    public Strategy getStrategy() {
        if (strategies.isEmpty()) {
            throw new IllegalStateException("Collection of strategies should not be empty.");
        }

        return strategies.get(random.nextInt(strategies.size()));
    }
}
