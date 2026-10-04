package week2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LeetCode 347 - Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Pipeline: count with groupingBy/counting -> sort entries by count descending
 * -> limit(k) -> unbox to int[]. O(n + m log m) for m distinct values.
 */
public class Task06_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> freq = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return freq.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        Task06_TopKFrequentElements t = new Task06_TopKFrequentElements();
        int[] r = t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Arrays.sort(r);
        assert Arrays.equals(r, new int[]{1, 2});
        assert Arrays.equals(t.topKFrequent(new int[]{1}, 1), new int[]{1});
        System.out.println("Task06_TopKFrequentElements: OK");
    }
}
