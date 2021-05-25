package com.hoteach.naive.动态规划;

/**
 * @author 阿季
 * @date 2021-05-25 16:04
 */

public class 股票买卖 {

    /*
     状态转移方程：
     dp[i][k][0] = max{dp[i-1][k][0], dp[i-1][k][1]+prices[i]}=max{前一天就没有股票，前一天的股票卖了}
     dp[i][k][1] = max{dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]}=max{前一天就有，前一天买了股票}

     base case：
     dp[-1][k][0] = 0
     dp[-1][k][1] = -infinity
     dp[i][0][0] = 0
     dp[i][0][1] = -infinity
     */


    /**
     * dp[i][1][0] = max{dp[i-1][1][0], dp[i-1][1][1]+prices[i]} = max{dp[i-1][0], dp[i-1][1]+prices[i]} = dp[i][0]
     * dp[i][1][1] = max{dp[i-1][1][1], dp[i-1][0][0]-prices[i]} = max{dp[i-1][1][1], -prices[i]} = max{dp[i-1][1], -prices[i]} = dp[i][1]
     *
     * @param prices
     * @return
     */
    public int dpK1(int[] prices) {

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 < 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        股票买卖 c = new 股票买卖();
        int[] ints = {7,1,5,3,6,4};
        int i = c.dpK1(ints);
        System.out.println(i);
    }

}
