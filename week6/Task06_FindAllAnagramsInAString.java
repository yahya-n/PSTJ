package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 438 - Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Fixed-size sliding window of length |p| over s. Keep the letter counts of p
 * and of the current window; a window is an anagram when the two tables are
 * equal (checked in O(26), constant). O(n) time, O(1) space.
 */
public class Task06_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return result;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < m; i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window)) {
            result.add(0);
        }
        for (int i = m; i < n; i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(need, window)) {
                result.add(i - m + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Task06_FindAllAnagramsInAString t = new Task06_FindAllAnagramsInAString();
        assert t.findAnagrams("cbaebabacd", "abc").equals(Arrays.asList(0, 6));
        assert t.findAnagrams("abab", "ab").equals(Arrays.asList(0, 1, 2));
        assert t.findAnagrams("a", "ab").isEmpty();
        System.out.println("Task06_FindAllAnagramsInAString: OK");
    }
}
