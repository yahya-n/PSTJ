package week6;

import java.util.Scanner;

/**
 * HackerRank - Two Strings
 * https://www.hackerrank.com/challenges/two-strings/
 *
 * Two strings share a common substring iff they share a common character
 * (a single character is already a substring), so there is no need to look at
 * longer substrings. Mark the letters of s1, then probe with s2.
 * O(|s1| + |s2|) time, O(1) space.
 */
public class Task03_TwoStrings {
    static String twoStrings(String s1, String s2) {
        boolean[] present = new boolean[26];
        for (int i = 0; i < s1.length(); i++) {
            present[s1.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (present[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        StringBuilder out = new StringBuilder();
        while (p-- > 0) {
            out.append(twoStrings(in.next(), in.next())).append('\n');
        }
        System.out.print(out);
    }
}
