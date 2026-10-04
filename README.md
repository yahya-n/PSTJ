# PSTJ

Problem-solving practice in Java (JDK 17), organised by week. Each task is one file in a `weekN` package.

## Running

```bash
# compile everything
javac -d out week*/*.java

# LeetCode / GfG style tasks carry self-checks in main() - run with assertions on
java -ea -cp out week5.Task01_MaximumSubarray

# HackerRank / CodeChef style tasks read stdin, exactly like the judge
printf "6 3\n5 3 5 2 3 2\n" | java -cp out week2.Task07_JavaDequeue
```

On Windows use `;` instead of `:` if you ever need more than one classpath entry.

LeetCode files are written as `public class TaskNN_Name` with the LeetCode method inside it; to submit, paste the
method body into LeetCode's `class Solution`.

## Week 2 - Functional programming and streams
| # | Task | Topic |
|---|------|-------|
| 1 | [Remove Element](https://leetcode.com/problems/remove-element/) | `filter()` |
| 2 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | `filter()` |
| 3 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | `reduce()` |
| 4 | [Find the Highest Altitude](https://leetcode.com/problems/find-the-highest-altitude/) | `reduce()` |
| 5 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | stream pipeline |
| 6 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | stream pipeline |
| 7 | [Java Dequeue](https://www.hackerrank.com/challenges/java-dequeue/problem) | collections |
| 8 | [Java HashSet](https://www.hackerrank.com/challenges/java-hashset/problem) | collections |

## Week 3 - Date/time, collections, comparators
| # | Task | Topic |
|---|------|-------|
| 1 | [Java Date and Time](https://www.hackerrank.com/challenges/java-date-and-time/problem) | date/time |
| 2 | [Number of Days Between Two Dates](https://leetcode.com/problems/number-of-days-between-two-dates/) | date/time |
| 3 | [Day of the Year](https://leetcode.com/problems/day-of-the-year/) | date/time |
| 4 | [Day of the Week](https://leetcode.com/problems/day-of-the-week/) | date/time |
| 5 | [Java Priority Queue](https://www.hackerrank.com/challenges/java-priority-queue/problem) | collections |
| 6 | [Java Arraylist](https://www.hackerrank.com/challenges/java-arraylist/problem) | collections |
| 7 | [Largest Number](https://leetcode.com/problems/largest-number/) | custom comparator |
| 8 | [Java Comparator](https://www.hackerrank.com/challenges/java-comparator/problem) | custom comparator |
| 9 | "Task 2 in syllabus" | not implemented - the assignment does not say which problem this is |
| 10 | [Sort the People](https://leetcode.com/problems/sort-the-people/) | sorting logic |

## Week 4 - Constraint-driven design, patterns, matrices
| # | Task | Topic |
|---|------|-------|
| 1 | [Determine if String Halves Are Alike](https://leetcode.com/problems/determine-if-string-halves-are-alike/) | constraint-driven design |
| 2 | [Lapindromes (CodeChef LAPIN)](https://www.codechef.com/problems/LAPIN) | constraint-driven design |
| 3 | [Compare the Triplets](https://www.hackerrank.com/challenges/compare-the-triplets/problem) | competitive patterns |
| 4 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | competitive patterns |
| 5 | [Time Conversion](https://www.hackerrank.com/challenges/time-conversion/problem) | efficient code |
| 6 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | efficient code |
| 7 | [Diagonal Difference](https://www.hackerrank.com/challenges/diagonal-difference/) | matrix basics |
| 8 | [Transpose Matrix](https://leetcode.com/problems/transpose-matrix/) | matrix basics |
| - | [Multiply the Matrices](https://www.geeksforgeeks.org/problems/multiply-the-matrices-1587115620/) | Strassen's matrix multiplication (`Strassen_MatrixMultiplication`; run with `--test` for the self-check) |
| 9 | [Matrix Block Sum](https://leetcode.com/problems/matrix-block-sum/) | 2D prefix sums |
| 10 | [Matrix Layer Rotation](https://www.hackerrank.com/challenges/matrix-rotation-algo/) | matrix rotation |

## Week 5 - Subarrays, strings, naive matching
| # | Task | Topic |
|---|------|-------|
| 1 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | brute force -> Kadane |
| 2 | [The Birthday Bar](https://www.hackerrank.com/challenges/the-birthday-bar/problem) | sliding window |
| 3 | [The Maximum Subarray](https://www.hackerrank.com/challenges/maxsubarray/) | Kadane |
| 4 | [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/) | Kadane |
| 5 | [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/) | string handling |
| 6 | [Alternating Characters](https://www.hackerrank.com/challenges/alternating-characters/) | string handling |
| 7 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | sliding window |
| 8 | [Find and Replace Pattern](https://leetcode.com/problems/find-and-replace-pattern/) | bijection mapping |
| 9 | [String Matching in an Array](https://leetcode.com/problems/string-matching-in-an-array/) | naive matching |
| 10 | [Naive Pattern Searching](https://www.geeksforgeeks.org/dsa/naive-algorithm-for-pattern-searching/) | naive matching |

## Week 6 - KMP, Boyer-Moore topics, palindromes
| # | Task | Topic |
|---|------|-------|
| 1 | [String Similarity](https://www.hackerrank.com/challenges/string-similarity/) | Z-function / prefix reuse |
| 2 | [Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/) | KMP failure function |
| 3 | [Two Strings](https://www.hackerrank.com/challenges/two-strings/) | KMP applications |
| 4 | [Rotate String](https://leetcode.com/problems/rotate-string/) | KMP on `s + s` |
| 5 | [Mars Exploration](https://www.hackerrank.com/challenges/mars-exploration/) | pattern comparison |
| 6 | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | sliding window |
| 7 | [Palindrome Index](https://www.hackerrank.com/challenges/palindrome-index/problem) | two pointers |
| 8 | [Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string) | KMP |
| 9 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | Manacher |
| 10 | [Circular Palindromes](https://www.hackerrank.com/challenges/circular-palindromes/) | Manacher + range max |
