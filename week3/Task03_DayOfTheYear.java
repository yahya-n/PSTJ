package week3;

import java.time.LocalDate;

/**
 * LeetCode 1154 - Day of the Year
 * https://leetcode.com/problems/day-of-the-year/
 *
 * LocalDate already knows leap years. O(1).
 */
public class Task03_DayOfTheYear {
    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }

    public static void main(String[] args) {
        Task03_DayOfTheYear t = new Task03_DayOfTheYear();
        assert t.dayOfYear("2019-01-09") == 9;
        assert t.dayOfYear("2019-02-10") == 41;
        assert t.dayOfYear("2004-03-01") == 61;
        assert t.dayOfYear("2003-03-01") == 60;
        System.out.println("Task03_DayOfTheYear: OK");
    }
}
