package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GeeksforGeeks - Naive algorithm for Pattern Searching
 * https://www.geeksforgeeks.org/dsa/naive-algorithm-for-pattern-searching/
 *
 * Slide the pattern over the text one position at a time and compare
 * character by character; record every start index where all m characters match.
 * O(n * m) worst case (e.g. "AAAA...A" vs "AAAB"), O(1) extra space.
 */
public class Task10_NaivePatternSearching {
    public static List<Integer> search(String pat, String txt) {
        List<Integer> found = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        for (int i = 0; i + m <= n; i++) {
            int j = 0;
            while (j < m && txt.charAt(i + j) == pat.charAt(j)) {
                j++;
            }
            if (j == m) {
                found.add(i);
            }
        }
        return found;
    }

    public static void main(String[] args) {
        assert search("AABA", "AABAACAADAABAABA").equals(Arrays.asList(0, 9, 12));
        assert search("TEST", "THIS IS A TEST TEXT").equals(Arrays.asList(10));
        assert search("AAA", "AAAAA").equals(Arrays.asList(0, 1, 2));
        assert search("XYZ", "ABCDE").isEmpty();
        System.out.println(search("AABA", "AABAACAADAABAABA"));
        System.out.println("Task10_NaivePatternSearching: OK");
    }
}
