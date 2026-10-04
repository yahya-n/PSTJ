package week4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * GeeksforGeeks - Multiply the matrices (Strassen's matrix multiplication)
 * https://www.geeksforgeeks.org/problems/multiply-the-matrices-1587115620/
 *
 * Strassen splits each n x n matrix into four n/2 blocks and builds the product
 * from 7 block multiplications instead of 8, giving O(n^log2(7)) ~ O(n^2.81).
 * Inputs are zero-padded up to the next power of two and the result is cropped
 * back. Below LEAF the schoolbook O(n^3) loop is faster, so recursion stops there.
 */
public class Strassen_MatrixMultiplication {
    private static final int LEAF = 32;

    public static long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        int size = 1;
        while (size < n) {
            size <<= 1;
        }
        long[][] c = strassen(pad(a, size), pad(b, size));
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(c[i], 0, result[i], 0, n);
        }
        return result;
    }

    private static long[][] strassen(long[][] a, long[][] b) {
        int n = a.length;
        if (n <= LEAF) {
            return naive(a, b);
        }
        int h = n / 2;
        long[][] a11 = block(a, 0, 0, h), a12 = block(a, 0, h, h);
        long[][] a21 = block(a, h, 0, h), a22 = block(a, h, h, h);
        long[][] b11 = block(b, 0, 0, h), b12 = block(b, 0, h, h);
        long[][] b21 = block(b, h, 0, h), b22 = block(b, h, h, h);

        long[][] m1 = strassen(add(a11, a22), add(b11, b22));
        long[][] m2 = strassen(add(a21, a22), b11);
        long[][] m3 = strassen(a11, sub(b12, b22));
        long[][] m4 = strassen(a22, sub(b21, b11));
        long[][] m5 = strassen(add(a11, a12), b22);
        long[][] m6 = strassen(sub(a21, a11), add(b11, b12));
        long[][] m7 = strassen(sub(a12, a22), add(b21, b22));

        long[][] c11 = add(sub(add(m1, m4), m5), m7);
        long[][] c12 = add(m3, m5);
        long[][] c21 = add(m2, m4);
        long[][] c22 = add(add(sub(m1, m2), m3), m6);

        long[][] c = new long[n][n];
        for (int i = 0; i < h; i++) {
            System.arraycopy(c11[i], 0, c[i], 0, h);
            System.arraycopy(c12[i], 0, c[i], h, h);
            System.arraycopy(c21[i], 0, c[h + i], 0, h);
            System.arraycopy(c22[i], 0, c[h + i], h, h);
        }
        return c;
    }

    static long[][] naive(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                long aik = a[i][k];
                for (int j = 0; j < n; j++) {
                    c[i][j] += aik * b[k][j];
                }
            }
        }
        return c;
    }

    private static long[][] pad(long[][] m, int size) {
        long[][] p = new long[size][size];
        for (int i = 0; i < m.length; i++) {
            System.arraycopy(m[i], 0, p[i], 0, m.length);
        }
        return p;
    }

    private static long[][] block(long[][] m, int r, int c, int size) {
        long[][] out = new long[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(m[r + i], c, out[i], 0, size);
        }
        return out;
    }

    private static long[][] add(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    private static long[][] sub(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    /**
     * Default: read "n", then two n x n matrices from stdin and print their product.
     * With --test: self-check Strassen against the schoolbook product (run with java -ea).
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            long[][] a = new long[n][n];
            long[][] b = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextLong();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = in.nextLong();
                }
            }
            for (long[] row : multiply(a, b)) {
                StringBuilder sb = new StringBuilder();
                for (long v : row) {
                    sb.append(v).append(' ');
                }
                System.out.println(sb.toString().trim());
            }
            return;
        }
        assert Arrays.deepEquals(multiply(new long[][]{{1, 2}, {3, 4}}, new long[][]{{5, 6}, {7, 8}}),
                new long[][]{{19, 22}, {43, 50}});
        Random rnd = new Random(7);
        for (int n : new int[]{1, 3, 33, 64, 100, 130}) {
            long[][] a = new long[n][n];
            long[][] b = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = rnd.nextInt(2001) - 1000;
                    b[i][j] = rnd.nextInt(2001) - 1000;
                }
            }
            assert Arrays.deepEquals(multiply(a, b), naive(a, b)) : "mismatch for n=" + n;
        }
        System.out.println("Strassen_MatrixMultiplication: OK");
    }
}
