package sb;

public class Match {

    private final Team homeTeam;
    private final Team awayTeam;
    private Score score;
    private long start;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

}
