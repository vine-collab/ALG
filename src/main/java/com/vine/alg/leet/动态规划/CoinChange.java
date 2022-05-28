package com.vine.alg.leet.动态规划;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 换零钱
 *
 * @author 阿季
 * @date 2021-04-20 11:16
 */

public class CoinChange {


    public int coinChange(List<Integer> coins, Integer money, Map<Integer, Integer> cache) {


        Integer integer = cache.get(money);
        if (Objects.nonNull(integer)) {
            return integer;
        }

        if (money == 0) return 0;
        if (money < 0) return -1;

        int temp = Integer.MAX_VALUE;

        for (Integer coin : coins) {
            int result = coinChange(coins, money - coin, cache);
            if (result == -1) {
                continue;
            }
            temp = Math.min(result + 1, temp);
        }

        temp = temp == Integer.MAX_VALUE ? -1 : temp;
        cache.put(money, temp);
        return temp;
    }


    public int coinChange(List<Integer> coins, Integer money) {
        Integer[] dp = new Integer[money + 1];
        Arrays.fill(dp, money + 1);


        dp[0] = 0;
        for (int m = 0; m < dp.length; m++) {
            for (Integer coin : coins) {
                if (m - coin < 0) {
                    continue;
                }
                dp[m] = Math.min(dp[m], dp[m - coin] + 1);
            }
        }
        return dp[money] == money + 1 ? -1 : dp[money];
    }


    public int coinChangeMyself(List<Integer> coins, Integer money) {
        if (money == 0) {
            return 0;
        }
        if (money < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.size(); i++) {
            int temp = coinChangeMyself(coins, money - coins.get(i));
            // 过滤无解
            if (temp == -1) {
                continue;
            }
            result = Math.min(temp + 1, result);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int coinChangeDP(List<Integer> coins, Integer money) {
        Integer[] dp = new Integer[money + 1];
        Arrays.fill(dp, money + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (Integer coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[money] == money + 1 ? -1 : dp[money];

    }


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        long l = System.currentTimeMillis();
        int i = coinChange.coinChange(Arrays.asList(1, 3, 6), 11);
        System.out.println(i);
        System.out.println("--------");
        int i1 = coinChange.coinChangeMyself(Arrays.asList(6), 11);
        System.out.println(i1);
        System.out.println("--------");
        int dp = coinChange.coinChangeDP(Arrays.asList(6), 11);
        System.out.println(dp);
    }

}
