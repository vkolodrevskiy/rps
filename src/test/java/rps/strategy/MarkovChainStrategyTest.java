package rps.strategy;

import org.junit.Test;
import rps.model.Move;
import rps.model.StringHistory;

import static org.junit.Assert.assertEquals;

/**
 * {@link MarkovChainStrategy} tests.
 *
 * @author vkolodrevskiy
 */
public class MarkovChainStrategyTest {
    @Test
    public void getMove() throws Exception {
        // stays for [rpsr, rpsr, rpsp, rpss, rpsr]
        StringHistory history = new StringHistory("rpsrprpsrprpsprpssrpsrprps");
        Strategy strategy = new MarkovChainStrategy();
        assertEquals(Move.Paper, strategy.getMove(history));
    }
}