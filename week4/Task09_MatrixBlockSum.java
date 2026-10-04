package week4;

import java.util.Arrays;

/**
 * LeetCode 1314 - Matrix Block Sum
 * https://leetcode.com/problems/matrix-block-sum/
 *
 * Build a 2D prefix-sum table, then every k-radius block is four lookups
 * (inclusion-exclusion), clamped to the matrix bounds.
 * O(m * n) time and space instead of O(m * n * k^2) brute force.
 */
public class Task09_MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
            }
        }
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m, i + k + 1);
                int c2 = Math.min(n, j + k + 1);
                answer[i][j] = prefix[r2][c2] - prefix[r1][c2] - prefix[r2][c1] + prefix[r1][c1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Task09_MatrixBlockSum t = new Task09_MatrixBlockSum();
        assert Arrays.deepEquals(t.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1),
                new int[][]{{12, 21, 16}, {27, 45, 33}, {24, 39, 28}});
        assert Arrays.deepEquals(t.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2),
                new int[][]{{45, 45, 45}, {45, 45, 45}, {45, 45, 45}});
        System.out.println("Task09_MatrixBlockSum: OK");
    }
}
