package week2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * HackerRank - Java HashSet
 * https://www.hackerrank.com/challenges/java-hashset/problem
 *
 * After each pair is read, print how many distinct pairs have been seen.
 * Pairs are stored as "left right" strings, so order matters. O(t) expected.
 */
public class Task08_JavaHashset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Set<String> pairs = new HashSet<>();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String left = in.next();
            String right = in.next();
            pairs.add(left + " " + right);
            out.append(pairs.size()).append('\n');
        }
        System.out.print(out);
    }
}
