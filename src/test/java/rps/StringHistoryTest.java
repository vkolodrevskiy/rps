package rps;

import org.junit.Test;
import rps.model.History;
import rps.model.Move;
import rps.model.StringHistory;

import static org.junit.Assert.assertEquals;

/**
 * {@link StringHistory} tests.
 *
 * @author vkolodrevskiy
 */
public class StringHistoryTest {
    @Test
    public void getMostCommonChar() throws Exception {
        History history = new StringHistory("rrrppsrps");
        assertEquals(Move.valueOfCode('r'), history.getMostCommonMove());
        history.add(Move.Paper);
        history.add(Move.Paper);
        history.add(Move.Paper);
        assertEquals(Move.valueOfCode('p'), history.getMostCommonMove());
    }
}
