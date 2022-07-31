package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-05-28 5:53 PM
 */

public class $121_买卖股票的最佳时机 {


    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
     * <p>
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public static void main(String[] args) {
        $121_买卖股票的最佳时机 m = new $121_买卖股票的最佳时机();
        int[] ints = {7, 1, 5, 3, 6, 4};
        int i = m.maxProfit(ints);
        System.out.println(i);
    }


    /**
     * 状态：天数，交易的次数，当前的操作
     * 选择：买，卖，不操作
     * <p>
     * 本题买卖一次，所以交易的次数是固定的1；
     * dp[i][j][1] 表示第i天，至今至多能交易j次，手上有股票 能赚最多的钱
     * dp[i][j][0] 表示第i天，至今至多能交易j次，手上没有有股票 能赚最多的钱
     * <p>
     * 手里没有股票     前一天没有股票         前一天有股票，今天卖了
     * dp[i][1][0] = max{dp[i - 1][1][0], dp[i - 1][1][1] + price[i]}
     * 手里有股票         前一天有股票         前一天没有股票，今天买了股票了
     * dp[i][1][1] = max{dp[i - 1][1][1], dp[i - 1][0][0] - price[i]}
     * <p>
     * <p>
     * base case:
     * dp[0][j][k] = -无穷;
     * dp[i][0][k] = 0;
     * dp[i][j][0] = 0
     * <p>
     * 解释：j = 0 的 base case，所以 dp[i-1][0][0] = 0。
     * <p>
     * 现在发现 j 都是 1，不会改变，即 j 对状态转移已经没有影响了。
     * 可以进行进一步化简去掉所有 k：
     * <p>
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], -prices[i])
     * <p>
     * 结果在 dp[prices.length - 1][0] 第i天，手里没有股票
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
            dp[i][1] = Integer.max(dp[i - 1][1], - prices[i]);
        }

        return dp[prices.length - 1][0];


    }

}
