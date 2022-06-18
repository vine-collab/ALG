package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-06-18 5:53 PM
 */

public class $518_零钱兑换II {


    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * <p>
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * <p>
     * 假设每一种面额的硬币有无限个。
     * <p>
     * 题目数据保证结果符合 32 位带符号整数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：amount = 5, coins = [1, 2, 5]
     * 输出：4
     * 解释：有四种方式可以凑成总金额：
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     * 示例 2：
     * <p>
     * 输入：amount = 3, coins = [2]
     * 输出：0
     * 解释：只用面额 2 的硬币不能凑成总金额 3 。
     * 示例 3：
     * <p>
     * 输入：amount = 10, coins = [10]
     * 输出：1
     * <p>
     * 链接：https://leetcode.cn/problems/coin-change-2
     */
    public static void main(String[] args) {
        $518_零钱兑换II h = new $518_零钱兑换II();
        int change = h.change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }

    /**
     * 容量为amount的背包，有coins个物品
     * dp[i][j] 对于前i个物品，容量为j的背包，能装满的方法为 dp[i][j]
     *
     *
     *
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        // base case 金额为0，只有不装一种装法

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // 能装下
                if(j - coins[i - 1] >= 0) {
                    //          不使用第i个物品  使用（因为可以重复使用 i 保持不变）
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                // 装不下
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];


    }
}



















