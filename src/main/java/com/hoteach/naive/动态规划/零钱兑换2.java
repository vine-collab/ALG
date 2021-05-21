package com.hoteach.naive.动态规划;

/**
 * @author 阿季
 * @date 2021-05-21 15:15
 */

public class 零钱兑换2 {

    int change(int amount, int[] coins) {


        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }


    public static void main(String[] args) {
        零钱兑换2 c = new 零钱兑换2();

        int change = c.change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }
}
