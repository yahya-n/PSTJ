package week5;

import java.util.Scanner;

/**
 * HackerRank - The Maximum Subarray
 * https://www.hackerrank.com/challenges/maxsubarray/
 *
 * For each array print "max contiguous subarray sum, max subsequence sum".
 *  - contiguous: Kadane's algorithm.
 *  - subsequence: add up every positive value; if none is positive, the answer is the largest element.
 * O(n) per test.
 */
public class Task03_TheMaximumSubarray {
    static long[] maxSubarray(int[] arr) {
        long best = arr[0];
        long ending = arr[0];
        long positives = Math.max(arr[0], 0);
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ending = Math.max(arr[i], ending + arr[i]);
            best = Math.max(best, ending);
            if (arr[i] > 0) {
                positives += arr[i];
            }
            largest = Math.max(largest, arr[i]);
        }
        return new long[]{best, largest > 0 ? positives : largest};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            long[] r = maxSubarray(arr);
            out.append(r[0]).append(' ').append(r[1]).append('\n');
        }
        System.out.print(out);
    }
}
