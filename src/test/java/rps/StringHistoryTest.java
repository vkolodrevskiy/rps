package rps;

import org.junit.Test;
import rps.model.History;
import rps.model.Move;
import rps.model.StringHistory;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * {@link StringHistory} tests.
 *
 * @author vkolodrevskiy
 */
public class StringHistoryTest {
    @Test
    public void getMostCommonMove() {
        History history = new StringHistory("rrrppsrps");
        assertTrue(history.getMostCommonMove().isPresent());
        assertEquals(Move.valueOfCode('r'), history.getMostCommonMove().get());
        history.add(Move.Paper);
        history.add(Move.Paper);
        history.add(Move.Paper);
        assertTrue(history.getMostCommonMove().isPresent());
        assertEquals(Move.valueOfCode('p'), history.getMostCommonMove().get());
    }

    @Test
    public void getMostCommonMoveEmptyHistory() {
        History history = new StringHistory();
        assertFalse(history.getMostCommonMove().isPresent());
    }

    @Test
    public void length() {
        History history = new StringHistory("rpsrps");
        assertTrue(history.length() == 6);
    }

    @Test
    public void getMarkovChainMostCommonMove() {
        // stays for [rpsr, rpsr, rpsp, rpss, rpsr]
        StringHistory history = new StringHistory("rpsrprpsrprpsprpssrpsrprps");

        assertTrue(history.getMarkovChainMostCommonMove(((byte) 3)).isPresent());
        assertEquals(Move.Rock, history.getMarkovChainMostCommonMove(((byte) 3)).get());
    }
}
