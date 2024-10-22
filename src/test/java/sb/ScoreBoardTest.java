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
        sb.newMatch(new Pair(new Team("Uruguay"), new Team("Italy")));

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

        Pair p2 = new Pair(new Team("Germany"), new Team("France"));
        sb.newMatch(p2);
        sb.updateScore(p2, new Score(2, 2));

        Pair p3 = new Pair(new Team("Uruguay"), new Team("Italy"));
        sb.newMatch(p3);
        sb.updateScore(p3, new Score(6, 6));

        Pair p4 = new Pair(new Team("Argentina"), new Team("Australia"));
        sb.newMatch(p4);
        sb.updateScore(p4, new Score(3, 1));

        assertEquals("Uruguay", sb.summary().get(0).getPair().getHome().getName());
        assertEquals("Spain", sb.summary().get(1).getPair().getHome().getName());
        assertEquals("Mexico", sb.summary().get(2).getPair().getHome().getName());
        assertEquals("Argentina", sb.summary().get(3).getPair().getHome().getName());
        assertEquals("Germany", sb.summary().get(4).getPair().getHome().getName());
    }

    @Test
    void testShouldRemoveMatch() {
        Pair p0 = new Pair(new Team("Mexico"), new Team("Canada"));
        sb.newMatch(p0);
        sb.updateScore(p0, new Score(0, 5));

        sb.finishMatch(new Pair(new Team("Mexico"), new Team("Canada")));
        assertEquals(0, sb.summary().size());
    }

    @Test
    void testShouldNotAllowDuplicateMatches() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> {
                sb.newMatch(new Pair(new Team("Uruguay"), new Team("Italy")));
                sb.newMatch(new Pair(new Team("Uruguay"), new Team("Italy")));
            });
        assertEquals("Match is already playing", exception.getMessage());
    }
}
