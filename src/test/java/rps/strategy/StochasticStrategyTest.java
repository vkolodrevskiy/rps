package rps.strategy;

import org.junit.Test;
import rps.model.Move;
import rps.model.StringHistory;

import static org.junit.Assert.assertEquals;

/**
 * {@link StochasticStrategy} test.
 *
 * @author vkolodrevskiy
 */
public class StochasticStrategyTest {
    @Test
    public void getMove() throws Exception {
        Strategy strategy = new StatisticStrategy();
        Move move = strategy.getMove(new StringHistory("rpsrpsrpsss"));
        assertEquals(Move.Scissors, move);
    }
}
