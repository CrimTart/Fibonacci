package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input a positive integer n: ");
            int n = scanner.nextInt();
            if (n <= 0) throw new IllegalArgumentException();
            System.out.println("Nth Fibonacci number using 3 different methods: ");
            System.out.println("Using recursion: " + fibRecursive(n));
            System.out.println("Using a cycle: " + fibCyclical(n));
            System.out.println("Using the formula: " + fibFormula(n));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Integer must be positive.");
        }
        catch (Exception e) {
            System.out.println("Incorrect input parameters.");
        }
    }

    public static long fibRecursive(int n) {
        if (n == 1 || n == 2) return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    public static long fibCyclical(int n) {
        long first = 1, second = 1;
        for (int i = 1; i < n; i++) {
            second += first;
            first = second - first;
        }
        return first;
    }

    public static long fibFormula(int n) {
        double a = 0.5 * (1 + Math.sqrt(5)), b = -1 / a;
        return (long)((Math.pow(a,n) - Math.pow(b,n)) / Math.sqrt(5));
    }
}
