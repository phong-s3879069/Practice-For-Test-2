package SampleTest;

import java.awt.datatransfer.ClipboardOwner;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem2 {
    public static void main(String[] args) {

        Team a,b,c,d;
        a = new Team();
        a.name = "PhongA";
        b = new Team();
        b.name = "PhongB";
        c = new Team();
        c.name = "PhongC";
        d = new Team();
        d.name = "PhongD";
        a.win(b);

        a.win(c);

        a.lose(d);

        b.win(c);

        b.win(d);

        c.win(d);

// assume leader is a LeaderBoard object
        LeaderBoard leader = new LeaderBoard();

        leader.add(a);

        leader.add(b);

        leader.add(c);

        leader.add(d);

        Team[] teams = leader.rank();
        Team[] teams1 = leader.realRank();
        for (Team t: teams) {
            System.out.println(t);
        }
        System.out.println("------");
        for (Team t: teams1){
            System.out.println(t);
        }




    }
}

class LeaderBoard {
    ArrayList<Team> teams;

    public LeaderBoard() {
        teams = new ArrayList<Team>();
    }

    public void add(Team t) {
        teams.add(t);
    }

    public Team[] rank() {
        teams.sort(new TeamComparator());
        return teams.toArray(new Team[0]);
    }

    public Team[] realRank() {
        teams.sort(new TeamRealComparator());
        return teams.toArray(new Team[0]);
    }
}

class TeamComparator implements Comparator<Team> {
    public int compare(Team team1, Team team2) {
        if(team1.point > team2.point){
            return -1;
        }
        if (team1.point < team2.point) {
            return 1;
        }
        return 0;

    }
}

class TeamRealComparator implements Comparator<Team> {
    public int compare(Team team1, Team team2) {
        if(team1.point > team2.point){
            return -1;
        }
        if (team1.point < team2.point) {
            return 1;
        }
        if (team1.hasWon.contains(team2)) {
            return -1;
        }
        if (team2.hasWon.contains(team1)) {
            return 1;
        }
        return 0;
    }
}
class Team {
    String name;

    int point;

    ArrayList<Team> hasWon;



    public Team() {
        hasWon = new ArrayList<Team>();
    }

    @Override
    public String toString() {
        return name;
    }

    public void win(Team t) {
        this.point += 3;
        this.hasWon.add(t);
    }

    public void lose(Team t) {
        t.point += 3;
        t.hasWon.add(this);
    }

    public void draw(Team t) {
        t.point += 1;
        this.point += 1;
    }
}


