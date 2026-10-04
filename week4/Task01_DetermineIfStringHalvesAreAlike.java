package week4;

/**
 * LeetCode 1704 - Determine if String Halves Are Alike
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 *
 * One pass: +1 for a vowel in the first half, -1 for a vowel in the second.
 * The halves are alike when the balance ends at 0. O(n) time, O(1) space.
 */
public class Task01_DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0) {
                balance += i < half ? 1 : -1;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        Task01_DetermineIfStringHalvesAreAlike t = new Task01_DetermineIfStringHalvesAreAlike();
        assert t.halvesAreAlike("book");
        assert !t.halvesAreAlike("textbook");
        assert t.halvesAreAlike("AbCdEfGh");
        System.out.println("Task01_DetermineIfStringHalvesAreAlike: OK");
    }
}
