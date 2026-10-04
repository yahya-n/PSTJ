package week3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * LeetCode 1360 - Number of Days Between Two Dates
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 *
 * Parse both ISO dates and take the absolute day difference. O(1).
 */
public class Task02_NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        return (int) Math.abs(ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }

    public static void main(String[] args) {
        Task02_NumberOfDaysBetweenTwoDates t = new Task02_NumberOfDaysBetweenTwoDates();
        assert t.daysBetweenDates("2019-06-29", "2019-06-30") == 1;
        assert t.daysBetweenDates("2020-01-15", "2019-12-31") == 15;
        assert t.daysBetweenDates("2020-02-28", "2020-03-01") == 2;
        System.out.println("Task02_NumberOfDaysBetweenTwoDates: OK");
    }
}
