package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-06-07 8:32 PM
 */

public class $70_爬楼梯 {


    /**
     * https://leetcode.cn/problems/climbing-stairs/
     */

    public static void main(String[] args) {
        $70_爬楼梯 p = new $70_爬楼梯();
        int i = p.climbStairs(2);
        System.out.println(i);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[2] = 2;
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];


    }
}
