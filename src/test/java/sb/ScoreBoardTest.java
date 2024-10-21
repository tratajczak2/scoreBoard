package sb;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    @Test
    void testProjectSetup() {
        assertNotNull(new ScoreBoard());
    }

    @Test
    void testShouldStartNewMatch() {
        ScoreBoard sb = new ScoreBoard();
        sb.newMatch(new Team("Uruguay"), new Team("Italy"));

        assertEquals(1, sb.summary().size());
    }
}
