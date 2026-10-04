package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HackerRank - Java Arraylist
 * https://www.hackerrank.com/challenges/java-arraylist/problem
 *
 * Store the n lines as a list of lists, then answer each (line, position)
 * query (both 1-indexed) or print ANOTHER_ERROR! when it is out of range.
 * O(1) per query.
 */
public class Task06_JavaArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<List<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = in.nextInt();
            List<Integer> line = new ArrayList<>(d);
            for (int j = 0; j < d; j++) {
                line.add(in.nextInt());
            }
            lines.add(line);
        }
        int q = in.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x >= 1 && x <= n && y >= 1 && y <= lines.get(x - 1).size()) {
                out.append(lines.get(x - 1).get(y - 1));
            } else {
                out.append("ANOTHER_ERROR!");
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}
