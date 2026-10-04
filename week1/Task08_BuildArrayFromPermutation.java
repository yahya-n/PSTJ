package week1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 1920 - Build Array from Permutation
 * https://leetcode.com/problems/build-array-from-permutation/
 *
 * ans[i] = nums[nums[i]]; expressed as a map() over the values.
 * O(n) time, O(n) space for the result.
 */
public class Task08_BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        return IntStream.of(nums).map(i -> nums[i]).toArray();
    }

    public static void main(String[] args) {
        Task08_BuildArrayFromPermutation t = new Task08_BuildArrayFromPermutation();
        assert Arrays.equals(t.buildArray(new int[]{0, 2, 1, 5, 3, 4}), new int[]{0, 1, 2, 4, 5, 3});
        assert Arrays.equals(t.buildArray(new int[]{5, 0, 1, 2, 3, 4}), new int[]{4, 5, 0, 1, 2, 3});
        System.out.println("Task08_BuildArrayFromPermutation: OK");
    }
}
