package library.numbers;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/7/15.
 */
public class Fibonacci {

    public static int fib(int n) {
        if(n <= 2) return 1;
        else {
            return fib(n-1) + fib(n-2);
        }
    }

    private static int[] memo;
    public static int memoizedFib(int n) {
        if(memo[n] != 0) {
            return memo[n];
        }
        else {
            int f;
            if(n <= 2) {
                f = 1;
            }
            else {
                f = memoizedFib(n-1) + memoizedFib(n-2);
            }
            memo[n] = f;
            return f;
        }
    }

    public static int dpfib(int n) {
        int[] fib = new int[n+1];
        int f = 0;
        for(int i = 0; i <= n; i++) {
            if(i <= 2) f = 1;
            else f = fib[i-1] + fib[i-2];
            fib[i] = f;
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is " + fib(10) );

        memo = new int[n+1];
//        for(int i = 0; i < n+1; i++) memo[i] = -1;

        System.out.println("Fibonacci (using memoization) of " + n + " is " + memoizedFib(10) );
        System.out.println(Arrays.toString(memo));

        System.out.println("Fibonacci (using Dynamic Programming) of " + n + " is " + dpfib(10) );
    }
}
