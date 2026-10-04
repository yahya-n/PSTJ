package week1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * HackerRank - Java Sort
 * https://www.hackerrank.com/challenges/java-sort/problem
 *
 * Sort students by CGPA descending, then first name ascending, then id ascending,
 * using a comparator built from lambdas. Prints the first names. O(n log n).
 */
public class Task03_JavaSort {
    static class Student {
        final int id;
        final String fname;
        final double cgpa;

        Student(int id, String fname, double cgpa) {
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        List<Student> students = new ArrayList<>();
        while (n-- > 0) {
            students.add(new Student(in.nextInt(), in.next(), in.nextDouble()));
        }
        students.sort(Comparator.comparingDouble((Student s) -> s.cgpa).reversed()
                .thenComparing(s -> s.fname)
                .thenComparingInt(s -> s.id));
        students.forEach(s -> System.out.println(s.fname));
    }
}
