package rps.strategy;

import org.junit.Test;
import rps.model.Move;
import rps.model.StringHistory;

import static org.junit.Assert.assertEquals;

/**
 * {@link StatisticStrategy} test.
 *
 * @author vkolodrevskiy
 */
public class StatisticStrategyTest {
    @Test
    public void getMove() throws Exception {
        Strategy strategy = new StatisticStrategy();
        Move move = strategy.getMove(new StringHistory("rpsrpsrpsss"));
        // Scissors is most common - so Rock is expected for win.
        assertEquals(Move.Rock, move);
    }
}
