package week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HackerRank - Java Comparator
 * https://www.hackerrank.com/challenges/java-comparator/problem
 *
 * Sort players by score descending; ties are broken by name ascending.
 * O(n log n).
 */
public class Task08_JavaComparator {
    static class Player {
        final String name;
        final int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {
        @Override
        public int compare(Player a, Player b) {
            if (a.score != b.score) {
                return Integer.compare(b.score, a.score);
            }
            return a.name.compareTo(b.name);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(in.next(), in.nextInt());
        }
        Arrays.sort(players, new Checker());
        for (Player p : players) {
            System.out.println(p.name + " " + p.score);
        }
    }
}
