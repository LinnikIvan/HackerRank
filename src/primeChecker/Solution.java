package primeChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.in;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime prime = new Prime();
            prime.checkPrime(n1);
            prime.checkPrime(n1, n2);
            prime.checkPrime(n1, n2, n3);
            prime.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (Method method : methods) {
                if (set.contains(method.getName())) {
                    overload = true;
                    break;
                }
                set.add(method.getName());
            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Prime {
    public void checkPrime(int... numbers) {
        List<Integer> primes = new ArrayList<>();

        for (int number : numbers) {
            if (isPrime(number)) primes.add(number);
        }
        for (int i : primes) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private boolean isPrime(int a) {
        if (a == 1) return false;
        if (a == 2) return true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}