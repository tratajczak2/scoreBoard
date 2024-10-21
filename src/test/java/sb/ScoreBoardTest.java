package sb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    ScoreBoard sb;

    @BeforeEach
    void setup() {
        sb = new ScoreBoard();
    }

    @Test
    void testProjectSetup() {
        assertNotNull(new ScoreBoard());
    }

    @Test
    void testShouldStartNewMatch() {
        sb.newMatch(new Pair(
                new Team("Uruguay"), new Team("Italy")
        ));

        assertEquals(1, sb.summary().size());
    }

    @Test
    void testShouldUpdateMatchScoreAndReflectInSummary() {

        Pair p0 = new Pair(new Team("Mexico"), new Team("Canada"));
        sb.newMatch(p0);
        sb.updateScore(p0, new Score(0, 5));

        Pair p1 = new Pair(new Team("Spain"), new Team("Brazil"));
        sb.newMatch(p1);
        sb.updateScore(p1, new Score(10, 2));

        Pair p2 = new Pair(new Team("Uruguay"), new Team("Italy"));
        sb.newMatch(p2);
        sb.updateScore(p2, new Score(6, 6));

        System.out.println(sb.summary());
        assertEquals("Uruguay", sb.summary().get(0).getPair().getHome().getName());
    }
}
