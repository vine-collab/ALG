package com.vine.alg.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-05 4:13 PM
 */

public class 凑零钱 {

    public static void main(String[] args) {
        凑零钱 c = new 凑零钱();
        int[] coins = new int[]{1, 2, 3};
        int i = c.coinChange(coins, 3);
        System.out.println(i);

        int i1 = c.coinChangeWithMemo(coins, 3, new HashMap<>());
        System.out.println(i1);
        int i2 = c.coinsChangeDp(coins, 3);
        System.out.println(i2);
    }

    int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题无解时跳过，执行下一个
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }

            min = Integer.min(min, subProblem + 1);
        }
        return min != Integer.MAX_VALUE ? min : -1;

    }


    int coinChangeWithMemo(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.get(amount) != null) {
            return memo.get(amount);
        }

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题无解时跳过，执行下一个
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }

            min = Integer.min(min, subProblem + 1);
        }
        min = min != Integer.MAX_VALUE ? min : -1;
        memo.put(amount, min);
        return min;

    }

    /**
     * amount 元最少要dp[n] 个硬币凑出来
     * dp[n] 元素对应n 的个数
     *
     * @param coins
     * @param amount
     * @return
     */
    int coinsChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            // i 为子问题的金额数
            for (int coin : coins) {
                // 子问题无解
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Integer.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }


}









