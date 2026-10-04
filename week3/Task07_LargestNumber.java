package week3;

import java.util.Arrays;

/**
 * LeetCode 179 - Largest Number
 * https://leetcode.com/problems/largest-number/
 *
 * Custom comparator: a goes before b when the concatenation a+b is larger than b+a.
 * If the biggest piece is "0" every number is 0. O(n log n) comparisons.
 */
public class Task07_LargestNumber {
    public String largestNumber(int[] nums) {
        String[] parts = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(parts, (a, b) -> (b + a).compareTo(a + b));
        if (parts[0].equals("0")) {
            return "0";
        }
        return String.join("", parts);
    }

    public static void main(String[] args) {
        Task07_LargestNumber t = new Task07_LargestNumber();
        assert t.largestNumber(new int[]{10, 2}).equals("210");
        assert t.largestNumber(new int[]{3, 30, 34, 5, 9}).equals("9534330");
        assert t.largestNumber(new int[]{0, 0}).equals("0");
        assert t.largestNumber(new int[]{34323, 3432}).equals("343234323");
        System.out.println("Task07_LargestNumber: OK");
    }
}
