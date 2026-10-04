package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 890 - Find and Replace Pattern
 * https://leetcode.com/problems/find-and-replace-pattern/
 *
 * A word matches when there is a bijection between pattern letters and word
 * letters. Two arrays record the mapping in each direction and any conflict
 * rejects the word. O(total characters) time, O(1) extra space per word.
 */
public class Task08_FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matches = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                matches.add(word);
            }
        }
        return matches;
    }

    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        char[] wordToPattern = new char[128];
        char[] patternToWord = new char[128];
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (wordToPattern[w] == 0 && patternToWord[p] == 0) {
                wordToPattern[w] = p;
                patternToWord[p] = w;
            } else if (wordToPattern[w] != p || patternToWord[p] != w) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Task08_FindAndReplacePattern t = new Task08_FindAndReplacePattern();
        Set<String> r = new HashSet<>(t.findAndReplacePattern(
                new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
        assert r.equals(new HashSet<>(Arrays.asList("mee", "aqq")));
        assert t.findAndReplacePattern(new String[]{"a", "b", "c"}, "a").size() == 3;
        System.out.println("Task08_FindAndReplacePattern: OK");
    }
}
