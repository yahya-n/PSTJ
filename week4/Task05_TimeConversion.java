package week4;

import java.util.Scanner;

/**
 * HackerRank - Time Conversion
 * https://www.hackerrank.com/challenges/time-conversion/problem
 *
 * Convert hh:mm:ssAM/PM to 24-hour time. Taking the hour mod 12 maps 12 to 0;
 * PM then adds 12. Minutes and seconds are copied unchanged. O(1).
 */
public class Task05_TimeConversion {
    static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2)) % 12;
        if (s.endsWith("PM")) {
            hour += 12;
        }
        return String.format("%02d%s", hour, s.substring(2, 8));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(timeConversion(in.nextLine().trim()));
    }
}
