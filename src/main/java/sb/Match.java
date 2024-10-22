package sb;

import java.util.Comparator;

public class Match implements Comparator<Match> {

    private final Pair pair;
    private Score score;
    private int start;

    public Match(Pair pair) {
        this.pair = pair;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Pair getPair() {
        return pair;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return score.getHome() + score.getAway();
    }

    @Override
    public int compare(Match m1, Match m2) {
        int cmp = m1.getTotal() - m2.getTotal();
        if (cmp == 0) {
            if (m1.start > m2.start)
                return 1;
            else return -1;
        } else {
            return cmp;
        }
    }

    @Override
    public String toString() {
        return "Match{" +
                "pair=" + pair +
                ", score=" + score +
                ", start=" + start +
                '}';
    }
}
