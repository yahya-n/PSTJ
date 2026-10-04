package week5;

/**
 * LeetCode 918 - Maximum Sum Circular Subarray
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
 * The best subarray is either an ordinary one (Kadane max) or one that wraps
 * around, which equals total - (minimum ordinary subarray). If every element is
 * negative the "wrap" case would be an empty subarray, so return the Kadane max.
 * O(n) time, O(1) space, single pass.
 */
public class Task04_MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxEnding = 0;
        int minEnding = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        for (int x : nums) {
            total += x;
            maxEnding = Math.max(x, maxEnding + x);
            maxSum = Math.max(maxSum, maxEnding);
            minEnding = Math.min(x, minEnding + x);
            minSum = Math.min(minSum, minEnding);
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
    }

    public static void main(String[] args) {
        Task04_MaximumSumCircularSubarray t = new Task04_MaximumSumCircularSubarray();
        assert t.maxSubarraySumCircular(new int[]{1, -2, 3, -2}) == 3;
        assert t.maxSubarraySumCircular(new int[]{5, -3, 5}) == 10;
        assert t.maxSubarraySumCircular(new int[]{-3, -2, -3}) == -2;
        assert t.maxSubarraySumCircular(new int[]{3, -1, 2, -1}) == 4;
        assert t.maxSubarraySumCircular(new int[]{3, -2, 2, -3}) == 3;
        System.out.println("Task04_MaximumSumCircularSubarray: OK");
    }
}
