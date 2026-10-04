package week2;

import java.util.Arrays;

/**
 * LeetCode 1732 - Find the Highest Altitude
 * https://leetcode.com/problems/find-the-highest-altitude/
 *
 * The altitudes are the running (prefix) sums of gain, starting at 0.
 * reduce() carries {current altitude, highest altitude so far}.
 * O(n) time, O(1) extra space.
 */
public class Task04_FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int[] state = Arrays.stream(gain).boxed().reduce(
                new int[]{0, 0},
                (acc, g) -> {
                    int altitude = acc[0] + g;
                    return new int[]{altitude, Math.max(acc[1], altitude)};
                },
                (a, b) -> {
                    throw new UnsupportedOperationException("sequential only");
                });
        return state[1];
    }

    public static void main(String[] args) {
        Task04_FindTheHighestAltitude t = new Task04_FindTheHighestAltitude();
        assert t.largestAltitude(new int[]{-5, 1, 5, 0, -7}) == 1;
        assert t.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}) == 0;
        System.out.println("Task04_FindTheHighestAltitude: OK");
    }
}
