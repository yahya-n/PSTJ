package week6;

/**
 * LeetCode 796 - Rotate String
 * https://leetcode.com/problems/rotate-string/
 *
 * goal is a rotation of s iff it has the same length and appears inside s + s.
 * The search is done with KMP so it stays O(n) instead of O(n^2).
 */
public class Task04_RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return kmpIndexOf(s + s, goal) >= 0;
    }

    private int kmpIndexOf(String text, String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m; i++) {
            while (len > 0 && pattern.charAt(i) != pattern.charAt(len)) {
                len = lps[len - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        for (int i = 0, j = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task04_RotateString t = new Task04_RotateString();
        assert t.rotateString("abcde", "cdeab");
        assert !t.rotateString("abcde", "abced");
        assert t.rotateString("a", "a");
        assert !t.rotateString("ab", "abc");
        assert t.rotateString("aa", "aa");
        System.out.println("Task04_RotateString: OK");
    }
}
