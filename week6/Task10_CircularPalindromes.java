package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HackerRank - Circular Palindromes
 * https://www.hackerrank.com/challenges/circular-palindromes/
 *
 * For every rotation i, print the length of the longest palindromic substring of
 * s[i..] + s[..i].
 *
 * Every rotation is the window [i, i + n) of t = s + s. Manacher gives, for each
 * center c of t, how far a palindrome extends (d1 for odd, d2 for even lengths).
 * A palindrome of "half-length" k fits the window iff some center in a known
 * range has radius >= k, which is a range-maximum query (sparse table). That
 * condition is monotone in k, so each window is answered by binary search.
 * O(n log n) time and space.
 */
public class Task10_CircularPalindromes {
    static int[] circularPalindromes(String s) {
        int n = s.length();
        char[] t = (s + s).toCharArray();
        int[] odd = longestInWindows(manacherOdd(t), n, true);
        int[] even = longestInWindows(manacherEven(t), n, false);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.max(odd[i], even[i]);
        }
        return result;
    }

    /** d1[i] = number of odd-length palindromes centered at i (longest has length 2*d1[i]-1). */
    private static int[] manacherOdd(char[] s) {
        int n = s.length;
        int[] d1 = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s[i - k] == s[i + k]) {
                k++;
            }
            d1[i] = k--;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }
        return d1;
    }

    /** d2[i] = number of even-length palindromes centered between i-1 and i (longest has length 2*d2[i]). */
    private static int[] manacherEven(char[] s) {
        int n = s.length;
        int[] d2 = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);
            while (i + k < n && i - k - 1 >= 0 && s[i + k] == s[i - k - 1]) {
                k++;
            }
            d2[i] = k--;
            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }
        return d2;
    }

    /**
     * For each window start i in [0, n) returns the longest palindrome of the requested
     * parity lying inside t[i, i + n).
     *  odd:  length 2k-1 is possible iff max(d1[c]) >= k for c in [i+k-1, i+n-k]
     *  even: length 2k   is possible iff max(d2[c]) >= k for c in [i+k,   i+n-k]
     */
    private static int[] longestInWindows(int[] d, int n, boolean odd) {
        int size = d.length;
        int levels = 32 - Integer.numberOfLeadingZeros(size);
        int[][] sparse = new int[levels][];
        sparse[0] = d;
        for (int j = 1; j < levels; j++) {
            int len = size - (1 << j) + 1;
            if (len <= 0) {
                levels = j;
                break;
            }
            sparse[j] = new int[len];
            for (int x = 0; x < len; x++) {
                sparse[j][x] = Math.max(sparse[j - 1][x], sparse[j - 1][x + (1 << (j - 1))]);
            }
        }

        int[] best = new int[n];
        int maxK = odd ? (n + 1) / 2 : n / 2;
        for (int i = 0; i < n; i++) {
            int lo = odd ? 1 : 0;
            int hi = maxK;
            while (lo < hi) {
                int k = (lo + hi + 1) >>> 1;
                int from = odd ? i + k - 1 : i + k;
                int to = i + n - k;
                if (rangeMax(sparse, from, to) >= k) {
                    lo = k;
                } else {
                    hi = k - 1;
                }
            }
            best[i] = odd ? 2 * lo - 1 : 2 * lo;
        }
        return best;
    }

    private static int rangeMax(int[][] sparse, int from, int to) {
        int j = 31 - Integer.numberOfLeadingZeros(to - from + 1);
        return Math.max(sparse[j][from], sparse[j][to - (1 << j) + 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
        String s = in.readLine().trim();
        StringBuilder out = new StringBuilder();
        for (int v : circularPalindromes(s)) {
            out.append(v).append('\n');
        }
        System.out.print(out);
    }
}
