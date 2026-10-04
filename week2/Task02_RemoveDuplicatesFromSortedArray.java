package week2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 26 - Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Because the array is sorted, an element is a duplicate exactly when it equals
 * its predecessor. filter() on the indices keeps the first of every run.
 * O(n) time, O(n) extra space.
 */
public class Task02_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int[] unique = IntStream.range(0, nums.length)
                .filter(i -> i == 0 || nums[i] != nums[i - 1])
                .map(i -> nums[i])
                .toArray();
        System.arraycopy(unique, 0, nums, 0, unique.length);
        return unique.length;
    }

    public static void main(String[] args) {
        Task02_RemoveDuplicatesFromSortedArray t = new Task02_RemoveDuplicatesFromSortedArray();
        int[] a = {1, 1, 2};
        int k = t.removeDuplicates(a);
        assert k == 2 && Arrays.equals(Arrays.copyOf(a, k), new int[]{1, 2});
        int[] b = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = t.removeDuplicates(b);
        assert k == 5 && Arrays.equals(Arrays.copyOf(b, k), new int[]{0, 1, 2, 3, 4});
        System.out.println("Task02_RemoveDuplicatesFromSortedArray: OK");
    }
}
