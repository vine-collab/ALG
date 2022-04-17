package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-17 5:56 PM
 */

public class 背包问题0_1 {
    public static void main(String[] args) {
        try {
            背包问题0_1 b = new 背包问题0_1();
            int i = b.dp(3, 4, new int[]{2, 1, 3}, new int[]{4, 2, 3});
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
        选择：装或者不装
        状态：背包的容量，可选的物品，所以dp数组定义的二位数组
        dp[i][j] 表示：在背包容量为i，前j个物品，的最大价值为 dp[i][j]
        base case
        dp[0][j] = 0
        dp[i][0] = 0
        所以定义dp[n + 1][w + 1]
        dp[i][j] = max{dp[i][j - 1], dp[i - wt[j - 1]][j - 1] + val[j - 1]}
        return dp[n][w]
     */

    int dp(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[w + 1][n + 1];
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - wt[j - 1] < 0) {
                    // 装不下
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // 能装下, 选择装或者不装
                    dp[i][j] = Integer.max(dp[i - wt[j - 1]][j - 1] + val[j - 1], dp[i][j - 1]);
                }
            }
        }

        return dp[w][n];

    }

}
