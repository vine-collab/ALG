package com.vine.alg.leetcode.动态规划;

/**
 * @author 阿季
 * @date 2021-05-15 15:31
 */

public class 斐波拉契 {


    int fib(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }


    int fibDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


    int fib2(int n) {
        if (n == 1 || n == 2) return 1;
        int pre = 1;
        int temp = 0;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            temp = pre + curr;
            pre = curr;
            curr = temp;
        }

        return temp;

    }


    public static void main(String[] args) {
        斐波拉契 f = new 斐波拉契();
        int fib = f.fib(20);
        int i = f.fibDP(20);
        int n = f.fib2(20);
        System.out.println(fib + "---" + i + "---" + n);
    }

}
