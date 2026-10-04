package week6;

import java.util.Scanner;

/**
 * HackerRank - String Similarity
 * https://www.hackerrank.com/challenges/string-similarity/
 *
 * The similarity of s with its suffix starting at i is the length of their
 * longest common prefix, i.e. the Z-array value z[i] (z[0] = n). The answer is
 * sum(z). The Z-algorithm builds the array in O(n) by reusing the rightmost
 * matched window [l, r) instead of re-comparing characters.
 * (Same prefix-reuse idea as the KMP failure function.)
 */
public class Task01_StringSimilarity {
    static int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];
        z[0] = n;
        int l = 0;
        int r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) {
                z[i] = Math.min(r - i, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
        }
        return z;
    }

    static long stringSimilarity(String s) {
        long sum = 0;
        for (int v : zFunction(s)) {
            sum += v;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            out.append(stringSimilarity(in.next())).append('\n');
        }
        System.out.print(out);
    }
}
