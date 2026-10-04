package week1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HackerRank - Sorting: Comparator
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 *
 * Players are ordered by score descending, ties broken by name ascending.
 * The comparator is written as an anonymous class (Checker below wraps one
 * anonymous Comparator, the same shape the judge's template expects).
 * O(n log n).
 */
public class Task05_SortingComparator {
    static class Player {
        final String name;
        final int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {
        private final Comparator<Player> delegate = new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                if (a.score != b.score) {
                    return b.score - a.score;
                }
                return a.name.compareTo(b.name);
            }
        };

        @Override
        public int compare(Player a, Player b) {
            return delegate.compare(a, b);
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
