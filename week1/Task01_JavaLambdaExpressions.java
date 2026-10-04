package week1;

import java.util.Scanner;

/**
 * HackerRank - Java Lambda Expressions
 * https://www.hackerrank.com/challenges/java-lambda-expressions/problem
 *
 * Each query is "type number": 1 = odd/even, 2 = prime/composite, 3 = palindrome.
 * PerformOperation is a functional interface, so every check is a lambda.
 * Prime test is O(sqrt n); the others are O(digits).
 */
public class Task01_JavaLambdaExpressions {
    interface PerformOperation {
        boolean check(int a);
    }

    static class MyMath {
        static boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        PerformOperation isOdd() {
            return n -> n % 2 != 0;
        }

        PerformOperation isPrime() {
            return n -> {
                if (n < 2) {
                    return false;
                }
                for (long i = 2; i * i <= n; i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            };
        }

        PerformOperation isPalindrome() {
            return n -> {
                String s = String.valueOf(n);
                return new StringBuilder(s).reverse().toString().equals(s);
            };
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyMath ob = new MyMath();
        int t = in.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int type = in.nextInt();
            int num = in.nextInt();
            switch (type) {
                case 1:
                    out.append(MyMath.checker(ob.isOdd(), num) ? "ODD" : "EVEN");
                    break;
                case 2:
                    out.append(MyMath.checker(ob.isPrime(), num) ? "PRIME" : "COMPOSITE");
                    break;
                default:
                    out.append(MyMath.checker(ob.isPalindrome(), num) ? "PALINDROME" : "NOT PALINDROME");
                    break;
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}
