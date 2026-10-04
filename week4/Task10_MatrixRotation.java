package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * HackerRank - Matrix Layer Rotation
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/
 *
 * Each concentric ring is rotated independently. Walk a ring clockwise into a
 * flat array, then write it back shifted by r mod ringLength: a counter-clockwise
 * rotation by r moves the value at index (j + r) to index j.
 * O(m * n) total, independent of how large r is.
 */
public class Task10_MatrixRotation {
    static int[][] rotate(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            int len = 2 * (bottom - top + right - left);
            int[] rows = new int[len];
            int[] cols = new int[len];
            int p = 0;
            for (int j = left; j < right; j++) {
                rows[p] = top;
                cols[p++] = j;
            }
            for (int i = top; i < bottom; i++) {
                rows[p] = i;
                cols[p++] = right;
            }
            for (int j = right; j > left; j--) {
                rows[p] = bottom;
                cols[p++] = j;
            }
            for (int i = bottom; i > top; i--) {
                rows[p] = i;
                cols[p++] = left;
            }

            int shift = r % len;
            for (int j = 0; j < len; j++) {
                int src = (j + shift) % len;
                result[rows[j]][cols[j]] = matrix[rows[src]][cols[src]];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder out = new StringBuilder();
        for (int[] row : rotate(matrix, r)) {
            for (int j = 0; j < n; j++) {
                out.append(row[j]).append(j + 1 < n ? " " : "\n");
            }
        }
        System.out.print(out);
    }
}
