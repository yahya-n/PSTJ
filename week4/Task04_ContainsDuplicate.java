package week4;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 217 - Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Add values to a HashSet; add() returns false on the first repeat.
 * O(n) expected time, O(n) space (sorting would give O(n log n) / O(1)).
 */
public class Task04_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Task04_ContainsDuplicate t = new Task04_ContainsDuplicate();
        assert t.containsDuplicate(new int[]{1, 2, 3, 1});
        assert !t.containsDuplicate(new int[]{1, 2, 3, 4});
        assert t.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        System.out.println("Task04_ContainsDuplicate: OK");
    }
}
