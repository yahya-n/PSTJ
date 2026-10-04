package week6;

import java.util.Scanner;

/**
 * HackerRank - Palindrome Index
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 *
 * Two pointers walk inward until the first mismatch at (l, r). Removing exactly
 * one of those two characters must fix the string, so test whether skipping s[l]
 * leaves a palindrome; if so the answer is l, otherwise r. A string that is
 * already a palindrome returns -1. O(n) time, O(1) space.
 */
public class Task07_PalindromeIndex {
    static int palindromeIndex(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) ? l : r;
            }
            l++;
            r--;
        }
        return -1;
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            out.append(palindromeIndex(in.next())).append('\n');
        }
        System.out.print(out);
    }
}
