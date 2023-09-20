package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2023-09-20 8:59 AM
 */

public class $746_使用最小花费爬楼梯 {

    /**
     * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
     */
    public static void main(String[] args) {
        $746_使用最小花费爬楼梯 z = new $746_使用最小花费爬楼梯();

    }


    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // 表示从0爬到i所需要的花费
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];


    }

}
