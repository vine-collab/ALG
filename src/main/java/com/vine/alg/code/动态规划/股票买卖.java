package com.vine.alg.code.动态规划;

/**
 * @author 阿季
 * @date 2021-05-25 16:04
 */

public class 股票买卖 {

    /*
   「状态」有三个，第一个是天数，第二个是当天允许交易的最大次数，第三个是当前的持有状态（即之前说的 rest 的状态，我们不妨用 1 表示持有，0 表示没有持有）。
   「选择」：买入、卖出、无操作，我们用 buy, sell, rest 表示这三种选择

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
     * k = 1
     * <p>
     * <p>
     * dp[i][k][0] = max{dp[i-1][k][0], dp[i-1][k][1]+prices[i]}=max{前一天就没有股票，前一天股票卖了}
     * dp[i][k][1] = max{dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]}=max{前一天就有，前一天买了股票}
     *
     * @param prices
     * @return
     */
    public int maxProfitMaxK(int[] prices, int maxK) {

        int[][][] dp = new int[prices.length][maxK + 1][2];
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][1][1] = prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int k = maxK; k > 0; k--) {
                if (i - 1 == -1) {
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][maxK][0];
    }


    public int maxProfitMaxK2(int[] prices) {

        int dp_110 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_120 = 0, dp_121 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_120 = Math.max(dp_120, dp_121 + price);
            dp_121 = Math.max(dp_121, dp_110 - price);
            dp_110 = Math.max(dp_110, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);

        }
        return dp_120;
    }

    /**
     * k = 1
     * <p>
     * <p>
     * dp[i][1][0] = max{dp[i-1][1][0], dp[i-1][1][1]+prices[i]} = max{dp[i-1][0], dp[i-1][1]+prices[i]} = dp[i][0]
     * dp[i][1][1] = max{dp[i-1][1][1], dp[i-1][0][0]-prices[i]} = max{dp[i-1][1][1], -prices[i]} = max{dp[i-1][1], -prices[i]} = dp[i][1]
     *
     * @param prices
     * @return
     */
    public int maxProfitK1(int[] prices) {

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


    /**
     * k = infinity -> k == k-1
     * dp[i][k][0] = max{dp[i-1][k][0], dp[i-1][k][1]+prices[i]}=max{dp[i-1][0], dp[i-1][1]+prices[i]}=dp[i][0]
     * dp[i][k][1] = max{dp[i-1][k][1], dp[i-1][k][0]-prices[i]}=max{dp[i-1][1], dp[i-1][0]-prices[i]}=dp[i][1]
     *
     * @param prices
     * @return
     */
    public int maxProfitKInf(int[] prices) {

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 < 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }


        return dp[prices.length - 1][0];
    }


    public int maxProfitWithFee(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 < 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }


        return dp[prices.length - 1][0];
    }


    /**
     * k = +infinity with cooldown
     * 每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
     *
     * @param prices
     * @return
     */
    public int maxProfitKInfWithCoolDown(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 < 0 || i - 2 < 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }


        // int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_pre_0 = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     int temp = dp_i_0;
        //     dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
        //     dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[1]);
        //     dp_pre_0 = temp;
        // }
        // return dp_i_0;

        return dp[prices.length - 1][0];
    }


    public static void main(String[] args) {
        股票买卖 c = new 股票买卖();
        int[] ints = {7, 1, 5, 3, 6, 4};
        int i = c.maxProfitK1(ints);
        System.out.println(i);
        System.out.println("---------");
        ints = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(c.maxProfitKInf(ints));
        System.out.println("---------");
        ints = new int[]{1, 2, 3, 0, 2};
        System.out.println(c.maxProfitKInfWithCoolDown(ints));
        System.out.println("---------");
        ints = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(c.maxProfitWithFee(ints, 2));
        System.out.println("---------");
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(c.maxProfitMaxK(ints, 2));
        System.out.println("---------");
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(c.maxProfitMaxK2(ints));
    }

    public static int maxProfitK(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return greedy(prices);
        }
        int[][] t = new int[k][2];
        for (int i = 0; i < k; ++i)
            t[i][0] = Integer.MIN_VALUE;
        for (int p : prices) {
            t[0][0] = Math.max(t[0][0], -p);
            t[0][1] = Math.max(t[0][1], t[0][0] + p);
            for (int i = 1; i < k; ++i) {
                t[i][0] = Math.max(t[i][0], t[i - 1][1] - p);
                t[i][1] = Math.max(t[i][1], t[i][0] + p);
            }
        }
        return t[k - 1][1];
    }

    private static int greedy(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }


}
