package sb;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private final List<Match> board = new ArrayList<>();
    private int version = 0;

    public void newMatch(Pair pair) {
        if (findByPair(pair) != null)
            throw new IllegalArgumentException("Match is already playing");

        updateScore(pair, new Score(0, 0));
    }

    public List<Match> summary() {
        return board;
    }

    public Match findByPair(Pair pair) {
        return board.stream()
                .filter(m -> m.getPair().equals(pair))
                .findFirst().orElse(null);
    }

    public void updateScore(Pair pair, Score score) {
        Match match = findByPair(pair);
        if (match != null) {
            board.remove(match);
        } else {
            match = new Match(pair);
            match.setStart(version++);
        }
        match.setScore(score);

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

    public void finishMatch(Pair pair) {
        Match match = findByPair(pair);
        board.remove(match);
    }
}
