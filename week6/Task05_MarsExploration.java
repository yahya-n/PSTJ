package week6;

import java.util.Scanner;

/**
 * HackerRank - Mars Exploration
 * https://www.hackerrank.com/challenges/mars-exploration/
 *
 * The received message is "SOS" repeated; count the positions where the received
 * character differs from the expected one (expected = "SOS".charAt(i % 3)).
 * O(n) time, O(1) space.
 */
public class Task05_MarsExploration {
    static int marsExploration(String s) {
        String sos = "SOS";
        int changed = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos.charAt(i % 3)) {
                changed++;
            }
        }
        return changed;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(marsExploration(in.next()));
    }
}
