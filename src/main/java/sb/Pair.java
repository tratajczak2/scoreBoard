package sb;

import java.util.Objects;

public class Pair {
    private Team home;
    private Team away;

    public Pair(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return Objects.equals(home, pair.home) && Objects.equals(away, pair.away);
    }

    @Override
    public int hashCode() {
        return Objects.hash(home, away);
    }

    public Team getHome() {
        return home;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "home=" + home +
                ", away=" + away +
                '}';
    }
}
