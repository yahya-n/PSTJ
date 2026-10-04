package week1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 1470 - Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/
 *
 * Input [x1..xn, y1..yn] -> [x1, y1, x2, y2, ...]. Output index i takes
 * nums[i/2] when i is even and nums[n + i/2] when i is odd.
 * O(n) time, O(n) space.
 */
public class Task09_ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        return IntStream.range(0, 2 * n)
                .map(i -> i % 2 == 0 ? nums[i / 2] : nums[n + i / 2])
                .toArray();
    }

    public static void main(String[] args) {
        Task09_ShuffleTheArray t = new Task09_ShuffleTheArray();
        assert Arrays.equals(t.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3), new int[]{2, 3, 5, 4, 1, 7});
        assert Arrays.equals(t.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4), new int[]{1, 4, 2, 3, 3, 2, 4, 1});
        assert Arrays.equals(t.shuffle(new int[]{1, 1, 2, 2}, 2), new int[]{1, 2, 1, 2});
        System.out.println("Task09_ShuffleTheArray: OK");
    }
}
