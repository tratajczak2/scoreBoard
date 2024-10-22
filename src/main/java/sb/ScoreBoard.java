package sb;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private final List<Match> board = new ArrayList<>();
    private int version = 0;

    public void newMatch(Pair pair) {
        if (findByPair(pair) != null)
            throw new IllegalArgumentException("Match is already playing");

        Match match = new Match(pair);
        match.setScore(new Score(0, 0));
        match.setStart(version++);
        insertMatch(match);
    }

    public List<Match> summary() {
        return board;
    }

    public Match findByPair(Pair pair) {
        return board.stream()
                .filter(m -> m.getPair().equals(pair))
                .findFirst().orElse(null);
    }

    private void insertMatch(Match match) {
        // insert according to the score and start
        boolean inserted = false;
        int i;
        for (i = 0; i < board.size(); i++) {
            if (match.compare(match, board.get(i)) >= 0) {
                board.add(i, match);
                inserted = true;
                break;
            }
        }
        if (i == board.size() && !inserted) {
            board.add(match);
        }
    }

    public void updateScore(Pair pair, Score score) {
        Match match = findByPair(pair);
        match.setScore(score);
        board.remove(match);
        insertMatch(match);
    }

    public void finishMatch(Pair pair) {
        Match match = findByPair(pair);
        board.remove(match);
    }
}
