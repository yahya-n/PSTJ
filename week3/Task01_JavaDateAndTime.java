package week3;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * HackerRank - Java Date and Time
 * https://www.hackerrank.com/challenges/java-date-and-time/problem
 *
 * Input is "month day year"; print the weekday in upper case.
 * java.time does the calendar math. O(1).
 */
public class Task01_JavaDateAndTime {
    static String findDay(int month, int day, int year) {
        return LocalDate.of(year, month, day).getDayOfWeek().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();
        System.out.println(findDay(month, day, year));
    }
}
