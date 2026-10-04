package week4;

import java.util.Arrays;

/**
 * LeetCode 283 - Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 *
 * Two pointers: every non-zero is swapped forward to the next free slot, which
 * keeps relative order and shifts zeroes to the end in place.
 * O(n) time, O(1) space, single pass.
 */
public class Task06_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[slot];
                nums[slot] = nums[i];
                nums[i] = tmp;
                slot++;
            }
        }
    }

    public static void main(String[] args) {
        Task06_MoveZeroes t = new Task06_MoveZeroes();
        int[] a = {0, 1, 0, 3, 12};
        t.moveZeroes(a);
        assert Arrays.equals(a, new int[]{1, 3, 12, 0, 0});
        int[] b = {0};
        t.moveZeroes(b);
        assert Arrays.equals(b, new int[]{0});
        int[] c = {1, 2, 3};
        t.moveZeroes(c);
        assert Arrays.equals(c, new int[]{1, 2, 3});
        System.out.println("Task06_MoveZeroes: OK");
    }
}
