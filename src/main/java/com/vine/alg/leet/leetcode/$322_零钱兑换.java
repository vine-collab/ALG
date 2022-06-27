package com.vine.alg.leet.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-06-26 6:16 PM
 */

public class $322_零钱兑换 {


    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 示例1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * <p>
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * <p>
     * 链接：https://leetcode.cn/problems/coin-change
     */

    public static void main(String[] args) {
        $322_零钱兑换 l = new $322_零钱兑换();
        int i = l.dp(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    // 对于amount金额，最少使用硬币个数为
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        Integer m = memo.get(amount);
        if(m != null) {
            return m;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dp = coinChange(coins, amount - coin);
            if (dp == -1) {
                continue;
            }
            res = Integer.min(dp + 1, res);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo.put(amount, res);
        return res;
    }

    int dp(int[] coins, int amount) {
        // 金额为i时，最小硬币个数为dp[i]
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if(i - coin < 0) {
                    continue;
                }
                                    // 用硬币，             不用硬币
                dp[i] = Integer.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return  dp[amount] == amount +1  ? -1 : dp[amount];

    }


}














