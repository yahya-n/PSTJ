package week5;

/**
 * LeetCode 8 - String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Skip leading spaces, read an optional sign, then consume digits until the
 * first non-digit. Overflow is detected before it happens (result * 10 + digit
 * would exceed Integer.MAX_VALUE) and the value is clamped. O(n) time, O(1) space.
 */
public class Task05_StringToIntegerAtoi {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        int result = 0;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        Task05_StringToIntegerAtoi t = new Task05_StringToIntegerAtoi();
        assert t.myAtoi("42") == 42;
        assert t.myAtoi("   -042") == -42;
        assert t.myAtoi("1337c0d3") == 1337;
        assert t.myAtoi("0-1") == 0;
        assert t.myAtoi("words and 987") == 0;
        assert t.myAtoi("-91283472332") == Integer.MIN_VALUE;
        assert t.myAtoi("2147483647") == Integer.MAX_VALUE;
        assert t.myAtoi("2147483648") == Integer.MAX_VALUE;
        assert t.myAtoi("-2147483648") == Integer.MIN_VALUE;
        assert t.myAtoi("+") == 0;
        assert t.myAtoi("") == 0;
        System.out.println("Task05_StringToIntegerAtoi: OK");
    }
}
