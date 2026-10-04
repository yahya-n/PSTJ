package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 1408 - String Matching in an Array
 * https://leetcode.com/problems/string-matching-in-an-array/
 *
 * Naive pattern matching: for every word, slide it across each other (longer)
 * word and compare character by character. O(n^2 * L^2) worst case, fine for
 * the constraints (n <= 100, L <= 30).
 */
public class Task09_StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].length() < words[j].length() && naiveContains(words[j], words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    private boolean naiveContains(String text, String pattern) {
        for (int start = 0; start + pattern.length() <= text.length(); start++) {
            int k = 0;
            while (k < pattern.length() && text.charAt(start + k) == pattern.charAt(k)) {
                k++;
            }
            if (k == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Task09_StringMatchingInAnArray t = new Task09_StringMatchingInAnArray();
        assert new HashSet<>(t.stringMatching(new String[]{"mass", "as", "hero", "superhero"}))
                .equals(new HashSet<>(Arrays.asList("as", "hero")));
        assert new HashSet<>(t.stringMatching(new String[]{"leetcode", "et", "code"}))
                .equals(new HashSet<>(Arrays.asList("et", "code")));
        assert t.stringMatching(new String[]{"blue", "green", "bu"}).isEmpty();
        System.out.println("Task09_StringMatchingInAnArray: OK");
    }
}
