package com.vine.alg.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 阿季
 * @date 2022-04-05 9:21 AM
 */

public class 斐波拉契数列 {


    public static void main(String[] args) {
        斐波拉契数列 f = new 斐波拉契数列();
        long l = System.currentTimeMillis();
        System.out.println(f.fib(40));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);


        System.out.println(f.fibMemoHelper(40, new HashMap<>()));

        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);

        System.out.println(f.fibDP(40));

        long l3 = System.currentTimeMillis();
        System.out.println(l3 - l1);

        System.out.println(f.fibDPUltra(3));
    }

    int fibDPUltra(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int pre = 1;
        int pre_pre = 1;
        int r = 0;

        for (int i = 3; i <= n; i++) {
            r = pre + pre_pre;
            pre_pre = pre;
            pre = r;
        }

        return r;
    }

    int fibDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }

        return dp[n];

    }

    int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);

    }


    int fibMemoHelper(int n, Map<Integer, Integer> memos) {
        Integer memo = memos.get(n);
        if (Objects.nonNull(memo)) {
            return memo;
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int r = fibMemoHelper(n - 1, memos) + fibMemoHelper(n - 2, memos);
        memos.put(n, r);
        return r;
    }


}
