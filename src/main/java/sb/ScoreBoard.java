package sb;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<Match> board = new ArrayList<>();

    public Match newMatch(Pair pair) {
        Match match = new Match(pair);
        match.setScore(new Score(0, 0));
        match.setStart(System.nanoTime());

        board.add(0, match);
        return match;
    }

    public List<Match> summary() {
        return board;
    }

    public Match findByPair(Pair pair) {
        return board.stream()
                .filter(m -> m.getPair().equals(pair))
                .findFirst().get();
    }

    public void updateScore(Pair pair, Score score) {
        Match match = findByPair(pair);
        match.setScore(score);
        board.remove(match);
        // move according to the score
        if (board.size() == 0) {
            board.add(0, match);
        } else {
            for (int i = 0; i < board.size(); i++) {
                if (match.compare(match, board.get(i)) >= 0) {
                    board.add(i, match);
                } else {
                    board.add(match);
                }
                break;
            }
        }
    }
}
