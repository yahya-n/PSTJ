package week6;

/**
 * LeetCode 459 - Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * KMP failure function: lps[n-1] is the length of the longest proper prefix of s
 * that is also a suffix. The shortest period is then p = n - lps[n-1], and s is a
 * repetition of a shorter block exactly when lps[n-1] > 0 and p divides n.
 * O(n) time, O(n) space.
 */
public class Task02_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1, len = 0; i < n; i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        int period = n - lps[n - 1];
        return lps[n - 1] > 0 && n % period == 0;
    }

    public static void main(String[] args) {
        Task02_RepeatedSubstringPattern t = new Task02_RepeatedSubstringPattern();
        assert t.repeatedSubstringPattern("abab");
        assert !t.repeatedSubstringPattern("aba");
        assert t.repeatedSubstringPattern("abcabcabcabc");
        assert !t.repeatedSubstringPattern("a");
        assert t.repeatedSubstringPattern("aa");
        assert t.repeatedSubstringPattern("abaababaab");
        assert !t.repeatedSubstringPattern("abcabcab");
        System.out.println("Task02_RepeatedSubstringPattern: OK");
    }
}
