package week3;

import java.util.Arrays;

/**
 * LeetCode 2418 - Sort the People
 * https://leetcode.com/problems/sort-the-people/
 *
 * Sort the indices by height descending (custom comparator), then map back to names.
 * O(n log n).
 */
public class Task10_SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] order = new Integer[names.length];
        Arrays.setAll(order, i -> i);
        Arrays.sort(order, (a, b) -> Integer.compare(heights[b], heights[a]));
        String[] sorted = new String[names.length];
        for (int i = 0; i < order.length; i++) {
            sorted[i] = names[order[i]];
        }
        return sorted;
    }

    public static void main(String[] args) {
        Task10_SortThePeople t = new Task10_SortThePeople();
        assert Arrays.equals(t.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}),
                new String[]{"Mary", "Emma", "John"});
        assert Arrays.equals(t.sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150}),
                new String[]{"Bob", "Alice", "Bob"});
        System.out.println("Task10_SortThePeople: OK");
    }
}
