package week6;

/**
 * LeetCode 28 - Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 *
 * KMP: precompute the longest-proper-prefix-that-is-also-suffix table for the
 * needle, then scan the haystack once; on a mismatch fall back in the needle
 * via the table instead of re-reading haystack characters.
 * O(n + m) time, O(m) space.
 */
public class Task08_FindTheIndexOfTheFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m; i++) {
            while (len > 0 && needle.charAt(i) != needle.charAt(len)) {
                len = lps[len - 1];
            }
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task08_FindTheIndexOfTheFirstOccurrence t = new Task08_FindTheIndexOfTheFirstOccurrence();
        assert t.strStr("sadbutsad", "sad") == 0;
        assert t.strStr("leetcode", "leeto") == -1;
        assert t.strStr("mississippi", "issip") == 4;
        assert t.strStr("aaaaab", "aaab") == 2;
        assert t.strStr("a", "a") == 0;
        assert t.strStr("abc", "") == 0;
        System.out.println("Task08_FindTheIndexOfTheFirstOccurrence: OK");
    }
}
