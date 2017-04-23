package rps;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * {@link StringHistory} tests.
 *
 * @author vkolodrevskiy
 */
public class StringHistoryTest {
    @Test
    public void getMostCommonChar() throws Exception {
        History history = new StringHistory("rrrppsrps");
        assertEquals(new Character('r'), history.getMostCommonChar());
        history.add(Move.Paper);
        history.add(Move.Paper);
        history.add(Move.Paper);
        assertEquals(new Character('p'), history.getMostCommonChar());
    }
}