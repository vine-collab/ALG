package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-05-28 8:43 PM
 */

public class $122_买卖股票的最佳时机II {


    /**
     * 122. 买卖股票的最佳时机 II
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润 。
     * 示例 1：
     * <p>
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     * 总利润为 4 + 3 = 7 。
     * 示例 2：
     * <p>
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     * 总利润为 4 。
     * 示例 3：
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
     */
    public static void main(String[] args) {
        $122_买卖股票的最佳时机II m = new $122_买卖股票的最佳时机II();
        int i = m.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(i);
    }


    /*
    k：0 不持有，1 持有
    i：表示第i天
    j：表示交易的次数，本题不限制交易次数
    dp[i][j][k]

    第i天不持有股票    i-1 天不持有    i-1天持有，第i天卖了
    dp[i][0] = max{dp[i - 1][0], dp[i - 1][1] + price[i]}

    第i天持有股票    i-1 天持有      i-1天不持有，第i天埋了
    dp[i][1] = max{dp[i - 1][1], dp[i - 1][0] - price[i]}


    base case
    dp[0][0] = 0;
    dp[0][1] = -无穷 不存在这种情况
    
    结果在dp[n - 1][0]
     */

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {

            if (i - 1 < 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }


            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Integer.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];


    }


}
