package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-05-30 9:13 AM
 */

public class $309_最佳买卖股票时机含冷冻期 {


    /**
     * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * 示例 2:
     * <p>
     * 输入: prices = [1]
     * 输出: 0
     * <p>
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
     */

    public static void main(String[] args) {
        $309_最佳买卖股票时机含冷冻期 z = new $309_最佳买卖股票时机含冷冻期();
        int i = z.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 < 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            if (i - 2 < 0) {
                // base case 2
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                // i - 2 小于 0 时根据状态转移方程推出对应 base case
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
                continue;
            }

            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Integer.max(dp[i - 1][1], dp[i - 2][0]  - prices[i]);
        }

        return dp[prices.length - 1][0];

    }


}






















