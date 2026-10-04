package week1;

import java.util.stream.IntStream;

/**
 * LeetCode 905 - Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * Two lambda predicates (even / odd) select the elements and the two streams are
 * concatenated: all evens first, then all odds. Any valid order within each
 * group is accepted. O(n) time, O(n) space.
 */
public class Task04_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        return IntStream.concat(
                IntStream.of(nums).filter(x -> x % 2 == 0),
                IntStream.of(nums).filter(x -> x % 2 != 0)).toArray();
    }

    public static void main(String[] args) {
        Task04_SortArrayByParity t = new Task04_SortArrayByParity();
        for (int[] input : new int[][]{{3, 1, 2, 4}, {0}, {1, 3, 5}, {2, 4, 6}, {1, 0, 3, 2}}) {
            int[] r = t.sortArrayByParity(input);
            assert r.length == input.length;
            boolean seenOdd = false;
            for (int x : r) {
                if (x % 2 != 0) {
                    seenOdd = true;
                } else {
                    assert !seenOdd : "even after odd";
                }
            }
            assert IntStream.of(r).sum() == IntStream.of(input).sum();
        }
        System.out.println("Task04_SortArrayByParity: OK");
    }
}
