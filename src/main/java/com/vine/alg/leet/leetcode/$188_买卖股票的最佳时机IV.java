package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-07-23 6:32 PM
 */

public class $188_买卖股票的最佳时机IV {

    /**
     * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1：
     * <p>
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * 示例 2：
     * <p>
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     * 输出：7
     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv
     */
    public static void main(String[] args) {
        $188_买卖股票的最佳时机IV m = new $188_买卖股票的最佳时机IV();
        int i = m.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(i);
    }

    public int maxProfit(int K, int[] prices) {
        if (prices.length == 0 || K == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][K + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k < K + 1; k++) {
                if (i - 1 < 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }

                dp[i][k][0] = Integer.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Integer.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][K][0];


    }


}































































