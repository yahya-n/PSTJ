package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 49 - Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Pipeline: stream the words -> classify each by its sorted letters -> collect
 * with groupingBy. O(n * k log k) time for n words of length k.
 */
public class Task05_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(Task05_GroupAnagrams::sortedKey))
                .values());
    }

    private static String sortedKey(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        List<List<String>> groups = new Task05_GroupAnagrams()
                .groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> normalized = groups.stream()
                .map(g -> g.stream().sorted().collect(Collectors.toList()))
                .sorted((a, b) -> a.get(0).compareTo(b.get(0)))
                .collect(Collectors.toList());
        assert normalized.equals(Arrays.asList(
                Arrays.asList("ate", "eat", "tea"),
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan")));
        assert new Task05_GroupAnagrams().groupAnagrams(new String[]{""}).size() == 1;
        System.out.println("Task05_GroupAnagrams: OK");
    }
}
