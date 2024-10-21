package sb;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<Match> board = new ArrayList<>();

    public void newMatch(Team homeTeam, Team awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        match.setScore(new Score(0, 0));

        board.add(0, match);
    }

    public List<Match> summary() {
        return board;
    }
}
