package com.vine.alg.code.topcode;

import com.vine.alg.基本数据结构构造.Utils;

/**
 * @author 阿季
 * @date 2022-08-23 9:41 PM
 */

public class $122_买卖股票的最佳时机II {

    public static void main(String[] args) {
        $122_买卖股票的最佳时机II m = new $122_买卖股票的最佳时机II();
        int i = m.maxProfit(Utils.splitToIntArr1("7,1,5,3,6,4"));
        System.out.println(i);
    }


    public int maxProfit(int[] prices) {
        // dp 第i天，手里是否有股票是能获得最大利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 最后一天，手里没有股票
        return dp[prices.length - 1][0];
    }


}































































