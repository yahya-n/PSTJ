package week5;

import java.util.Scanner;

/**
 * HackerRank - Alternating Characters
 * https://www.hackerrank.com/challenges/alternating-characters/
 *
 * Every character equal to its predecessor must be deleted, so the answer is
 * the number of adjacent equal pairs. O(n) per string.
 */
public class Task06_AlternatingCharacters {
    static int alternatingCharacters(String s) {
        int deletions = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            out.append(alternatingCharacters(in.next())).append('\n');
        }
        System.out.print(out);
    }
}
