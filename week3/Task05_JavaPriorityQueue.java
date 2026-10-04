package week3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * HackerRank - Java Priority Queue
 * https://www.hackerrank.com/challenges/java-priority-queue/problem
 *
 * Students are served by highest CGPA, then name (A-Z), then id (ascending).
 * A PriorityQueue with that comparator gives O(log n) per ENTER / SERVED.
 */
public class Task05_JavaPriorityQueue {
    static class Student {
        final int id;
        final String name;
        final double cgpa;

        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }
    }

    static final Comparator<Student> PRIORITY =
            Comparator.comparingDouble((Student s) -> s.cgpa).reversed()
                    .thenComparing(s -> s.name)
                    .thenComparingInt(s -> s.id);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int events = Integer.parseInt(in.nextLine().trim());
        PriorityQueue<Student> queue = new PriorityQueue<>(PRIORITY);
        for (int i = 0; i < events; i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts[0].equals("ENTER")) {
                queue.add(new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2])));
            } else {
                queue.poll();
            }
        }
        if (queue.isEmpty()) {
            System.out.println("EMPTY");
            return;
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().name);
        }
    }
}
