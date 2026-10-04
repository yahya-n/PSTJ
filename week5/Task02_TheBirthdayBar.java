package week5;

import java.util.Scanner;

/**
 * HackerRank - Subarray Division 1 (The Birthday Bar)
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 *
 * Count the contiguous segments of length m whose sum equals d. A sliding
 * window updates the sum in O(1) per step: O(n) time, O(1) space.
 */
public class Task02_TheBirthdayBar {
    static int birthday(int[] s, int d, int m) {
        if (s.length < m) {
            return 0;
        }
        int sum = 0;
        int ways = 0;
        for (int i = 0; i < s.length; i++) {
            sum += s[i];
            if (i >= m) {
                sum -= s[i - m];
            }
            if (i >= m - 1 && sum == d) {
                ways++;
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        System.out.println(birthday(s, d, m));
    }
}
