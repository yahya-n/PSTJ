package week3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * LeetCode 1185 - Day of the Week
 * https://leetcode.com/problems/day-of-the-week/
 *
 * Build the LocalDate and print the weekday name ("Sunday", ...). O(1).
 */
public class Task04_DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        DayOfWeek dow = LocalDate.of(year, month, day).getDayOfWeek();
        return dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static void main(String[] args) {
        Task04_DayOfTheWeek t = new Task04_DayOfTheWeek();
        assert t.dayOfTheWeek(31, 8, 2019).equals("Saturday");
        assert t.dayOfTheWeek(18, 7, 1999).equals("Sunday");
        assert t.dayOfTheWeek(15, 8, 1993).equals("Sunday");
        System.out.println("Task04_DayOfTheWeek: OK");
    }
}
