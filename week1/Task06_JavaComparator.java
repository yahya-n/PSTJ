package week1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HackerRank - Java Comparator
 * https://www.hackerrank.com/challenges/java-comparator/problem
 *
 * Same ordering as Task05 (score descending, then name ascending) but the
 * Comparator is composed from method references with the functional-interface
 * helpers comparingInt / reversed / thenComparing. O(n log n).
 */
public class Task06_JavaComparator {
    static class Player {
        final String name;
        final int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {
        private static final Comparator<Player> ORDER =
                Comparator.comparingInt((Player p) -> p.score).reversed()
                        .thenComparing(p -> p.name);

        @Override
        public int compare(Player a, Player b) {
            return ORDER.compare(a, b);
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
