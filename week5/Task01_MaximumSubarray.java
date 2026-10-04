package week5;

/**
 * LeetCode 53 - Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Brute force -> optimized:
 *   1. bruteForce: try every start, extend the end while keeping a running sum. O(n^2) time, O(1) space.
 *   2. kadane:     best sum ending at i is max(nums[i], best ending at i-1 + nums[i]). O(n) time, O(1) space.
 */
public class Task01_MaximumSubarray {
    public int maxSubArrayBruteForce(int[] nums) {
        int best = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int ending = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ending = Math.max(nums[i], ending + nums[i]);
            best = Math.max(best, ending);
        }
        return best;
    }

    public static void main(String[] args) {
        Task01_MaximumSubarray t = new Task01_MaximumSubarray();
        int[][] cases = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1},
                {5, 4, -1, 7, 8},
                {-3, -2, -5},
        };
        int[] expected = {6, 1, 23, -2};
        for (int i = 0; i < cases.length; i++) {
            assert t.maxSubArray(cases[i]) == expected[i];
            assert t.maxSubArrayBruteForce(cases[i]) == expected[i];
        }
        System.out.println("Task01_MaximumSubarray: OK");
    }
}
