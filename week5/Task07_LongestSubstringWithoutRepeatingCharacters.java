package week5;

import java.util.Arrays;

/**
 * LeetCode 3 - Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Sliding window: remember the last index of every character; when a character
 * repeats inside the window, move the left edge just past its previous position.
 * O(n) time, O(1) space (fixed 128-entry table).
 */
public class Task07_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int best = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }
            lastSeen[c] = right;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        Task07_LongestSubstringWithoutRepeatingCharacters t = new Task07_LongestSubstringWithoutRepeatingCharacters();
        assert t.lengthOfLongestSubstring("abcabcbb") == 3;
        assert t.lengthOfLongestSubstring("bbbbb") == 1;
        assert t.lengthOfLongestSubstring("pwwkew") == 3;
        assert t.lengthOfLongestSubstring("") == 0;
        assert t.lengthOfLongestSubstring("abba") == 2;
        assert t.lengthOfLongestSubstring(" ") == 1;
        System.out.println("Task07_LongestSubstringWithoutRepeatingCharacters: OK");
    }
}
