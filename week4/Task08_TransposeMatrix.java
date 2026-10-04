package week4;

import java.util.Arrays;

/**
 * LeetCode 867 - Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/
 *
 * The matrix may be rectangular, so allocate an n x m result and copy
 * result[j][i] = matrix[i][j]. O(m * n) time and space.
 */
public class Task08_TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Task08_TransposeMatrix t = new Task08_TransposeMatrix();
        assert Arrays.deepEquals(t.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});
        assert Arrays.deepEquals(t.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}),
                new int[][]{{1, 4}, {2, 5}, {3, 6}});
        System.out.println("Task08_TransposeMatrix: OK");
    }
}
