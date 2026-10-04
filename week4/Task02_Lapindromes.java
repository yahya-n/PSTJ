package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CodeChef LAPIN - Lapindromes
 * https://www.codechef.com/problems/LAPIN
 *
 * Split the string in two halves (the middle character of an odd-length string
 * is ignored). It is a lapindrome when both halves contain the same letters
 * with the same frequencies. O(n) per test using a frequency table.
 */
public class Task02_Lapindromes {
    static boolean isLapindrome(String s) {
        int n = s.length();
        int[] diff = new int[26];
        for (int i = 0; i < n / 2; i++) {
            diff[s.charAt(i) - 'a']++;
            diff[s.charAt(n - 1 - i) - 'a']--;
        }
        for (int d : diff) {
            if (d != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            out.append(isLapindrome(in.readLine().trim()) ? "YES" : "NO").append('\n');
        }
        System.out.print(out);
    }
}
