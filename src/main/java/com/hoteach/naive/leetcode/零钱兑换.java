package com.hoteach.naive.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * @author 阿季
 * @date 2021-06-03 14:15
 */

public class 零钱兑换 {


    private Map<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Integer integer = cache.get(amount);
        if (integer != null) {
            return integer;
        }

        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subAmount = coinChange(coins, amount - coin);
            if (subAmount == -1) {
                continue;
            }
            int num = subAmount + 1;
            result = Math.min(num, result);
        }
        result = result == Integer.MAX_VALUE ? -1 : result;
        cache.put(amount, result);

        return result;
    }


    public static void main(String[] args) {

        零钱兑换 c = new 零钱兑换();
        int i = c.coinChange(new int[]{1}, 11);
        System.out.println(i);
    }

}
