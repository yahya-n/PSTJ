package week2;

import java.util.Arrays;

/**
 * LeetCode 53 - Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Kadane's algorithm expressed as a reduce(). The accumulator carries
 * {best sum ending at the current element, best sum seen so far}.
 * O(n) time, O(1) extra space. Sequential streams only (the combiner is not meaningful).
 */
public class Task03_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] state = Arrays.stream(nums).boxed().reduce(
                new int[]{0, Integer.MIN_VALUE},
                (acc, x) -> {
                    int ending = Math.max(x, acc[0] + x);
                    return new int[]{ending, Math.max(acc[1], ending)};
                },
                (a, b) -> {
                    throw new UnsupportedOperationException("sequential only");
                });
        return state[1];
    }

    public static void main(String[] args) {
        Task03_MaximumSubarray t = new Task03_MaximumSubarray();
        assert t.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6;
        assert t.maxSubArray(new int[]{1}) == 1;
        assert t.maxSubArray(new int[]{5, 4, -1, 7, 8}) == 23;
        assert t.maxSubArray(new int[]{-3, -2, -5}) == -2;
        System.out.println("Task03_MaximumSubarray: OK");
    }
}
