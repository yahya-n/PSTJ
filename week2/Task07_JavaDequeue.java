package week2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HackerRank - Java Dequeue
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 *
 * Slide a window of size m over the array. The deque holds the window in order
 * and a count map tracks how many distinct values it contains.
 * O(n) time, O(m) space.
 */
public class Task07_JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> window = new ArrayDeque<>();
        Map<Integer, Integer> count = new HashMap<>();
        int best = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            window.addLast(x);
            count.merge(x, 1, Integer::sum);
            if (window.size() > m) {
                int old = window.removeFirst();
                if (count.merge(old, -1, Integer::sum) == 0) {
                    count.remove(old);
                }
            }
            if (window.size() == m) {
                best = Math.max(best, count.size());
            }
        }
        System.out.println(best);
    }
}
