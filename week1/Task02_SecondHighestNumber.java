package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Second highest number using the Stream API (print -1 if there is none).
 *
 * Pipeline: distinct() so repeated maxima count once -> sorted descending ->
 * skip(1) the highest -> findFirst(); an empty result means -1.
 * O(n log n) time, O(n) space.
 */
public class Task02_SecondHighestNumber {
    static int secondHighest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numbers.add(in.nextInt());
        }
        System.out.println(secondHighest(numbers));
    }
}
