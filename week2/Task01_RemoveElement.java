package week2;

import java.util.Arrays;

/**
 * LeetCode 27 - Remove Element
 * https://leetcode.com/problems/remove-element/
 *
 * filter() keeps every element that is not val; the survivors are copied back
 * to the front of the array. O(n) time, O(n) extra space.
 */
public class Task01_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int[] kept = Arrays.stream(nums).filter(x -> x != val).toArray();
        System.arraycopy(kept, 0, nums, 0, kept.length);
        return kept.length;
    }

    public static void main(String[] args) {
        Task01_RemoveElement t = new Task01_RemoveElement();
        int[] a = {3, 2, 2, 3};
        int k = t.removeElement(a, 3);
        assert k == 2 && a[0] == 2 && a[1] == 2;
        int[] b = {0, 1, 2, 2, 3, 0, 4, 2};
        k = t.removeElement(b, 2);
        assert k == 5 && Arrays.equals(Arrays.copyOf(b, k), new int[]{0, 1, 3, 0, 4});
        System.out.println("Task01_RemoveElement: OK");
    }
}
