package javaLambdaExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    public PerformOperation isPrime() {
        return a -> {
            for (int i = 2; i < a; i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return a -> {
            String value = String.valueOf(a);
            return value.equals(new StringBuilder(value).reverse().toString());
        };
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        MyMath math = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation operation;
        boolean result;
        String answer = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                operation = math.isOdd();
                result = MyMath.checker(operation, number);
                answer = (result) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                operation = math.isPrime();
                result = MyMath.checker(operation, number);
                answer = (result) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                operation = math.isPalindrome();
                result = MyMath.checker(operation, number);
                answer = (result) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(answer);
        }
    }
}

@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}