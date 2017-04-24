package rps.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Selecting strategy for move.
 *
 * @author vkolodrevskiy
 */
public class StrategyRoulette {
    private final List<Strategy> strategies;
    private final Random random = new Random();

    public StrategyRoulette() {
        this.strategies = new ArrayList<>(3);
    }

    public void addStrategy(Strategy strategy) {
        this.strategies.add(strategy);
    }

    public Strategy getStrategy() {
        if (strategies.isEmpty()) {
            throw new IllegalStateException("Collection of strategies should not be empty.");
        }

        // TODO: in future we can consider most winning strategies and select them based on that
        return strategies.get(random.nextInt(strategies.size()));
    }
}
