package week6;

/**
 * LeetCode 5 - Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Manacher's algorithm. Interleave '#' between characters so odd and even
 * palindromes both become odd ("abba" -> "#a#b#b#a#"), add sentinels at both
 * ends to avoid bounds checks, then compute the palindrome radius p[i] at every
 * center, reusing the mirror of i around the rightmost palindrome found so far.
 * O(n) time, O(n) space.
 */
public class Task09_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] t = new char[2 * n + 3];
        t[0] = '^';
        t[t.length - 1] = '$';
        for (int i = 0; i < n; i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[2 * n + 1] = '#';

        int[] p = new int[t.length];
        int center = 0;
        int right = 0;
        int bestCenter = 0;
        int bestRadius = 0;
        for (int i = 1; i < t.length - 1; i++) {
            if (i < right) {
                p[i] = Math.min(right - i, p[2 * center - i]);
            }
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (p[i] > bestRadius) {
                bestRadius = p[i];
                bestCenter = i;
            }
        }
        int start = (bestCenter - bestRadius) / 2;
        return s.substring(start, start + bestRadius);
    }

    public static void main(String[] args) {
        Task09_LongestPalindromicSubstring t = new Task09_LongestPalindromicSubstring();
        String r = t.longestPalindrome("babad");
        assert r.equals("bab") || r.equals("aba");
        assert t.longestPalindrome("cbbd").equals("bb");
        assert t.longestPalindrome("a").equals("a");
        assert t.longestPalindrome("racecar").equals("racecar");
        assert t.longestPalindrome("forgeeksskeegfor").equals("geeksskeeg");
        assert t.longestPalindrome("ac").length() == 1;
        System.out.println("Task09_LongestPalindromicSubstring: OK");
    }
}
