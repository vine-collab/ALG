package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-17 9:21 PM
 */

public class 完全背包问题_换硬币2 {
    public static void main(String[] args) {
        try {
            完全背包问题_换硬币2 b = new 完全背包问题_换硬币2();
            int dp = b.change(5, new int[]{1, 2, 5});
            System.out.println(dp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
        给定不同面额的硬币coins（每种硬币可以有无限多个），一个总金额 amount，写出可以凑成总金额的组合数
        dp[i][j]：表示前i个硬币，背包容量为j时，最多的装法为 dp[i][j]
        dp[0][j]=0
        dp[i][0]=1
        dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i]] 不装、装，因为每种硬币无限多个，可以重复使用所以，dp[i][j - nums[i]]

        dp[n + 1][amount + 1]
        结果dp[n][amount]
       

     */
    int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] +  dp[i] [j - coins[i - 1]];
                }
            }
        }


        return dp[n][amount];
    }
}
























