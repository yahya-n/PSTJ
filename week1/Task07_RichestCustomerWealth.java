package week1;

import java.util.Arrays;

/**
 * LeetCode 1672 - Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/
 *
 * Higher-order functions: map each customer's row to its sum, then take the max.
 * O(m * n) time, O(1) extra space.
 */
public class Task07_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customer -> Arrays.stream(customer).sum())
                .max()
                .getAsInt();
    }

    public static void main(String[] args) {
        Task07_RichestCustomerWealth t = new Task07_RichestCustomerWealth();
        assert t.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}) == 6;
        assert t.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}) == 10;
        assert t.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}) == 17;
        System.out.println("Task07_RichestCustomerWealth: OK");
    }
}
