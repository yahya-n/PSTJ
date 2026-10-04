package week4;

import java.util.Scanner;

/**
 * HackerRank - Diagonal Difference
 * https://www.hackerrank.com/challenges/diagonal-difference/
 *
 * |sum of primary diagonal - sum of secondary diagonal| of an n x n matrix.
 * O(n) after reading the input.
 */
public class Task07_DiagonalDifference {
    static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int primary = 0;
        int secondary = 0;
        for (int i = 0; i < n; i++) {
            primary += arr[i][i];
            secondary += arr[i][n - 1 - i];
        }
        return Math.abs(primary - secondary);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(diagonalDifference(arr));
    }
}
