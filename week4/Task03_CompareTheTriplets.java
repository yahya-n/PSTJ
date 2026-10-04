package week4;

import java.util.Scanner;

/**
 * HackerRank - Compare the Triplets
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 *
 * Compare the two triplets position by position and award a point to whoever is higher.
 * O(1).
 */
public class Task03_CompareTheTriplets {
    static int[] compareTriplets(int[] a, int[] b) {
        int[] points = new int[2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                points[0]++;
            } else if (a[i] < b[i]) {
                points[1]++;
            }
        }
        return points;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        int[] b = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            b[i] = in.nextInt();
        }
        int[] r = compareTriplets(a, b);
        System.out.println(r[0] + " " + r[1]);
    }
}
