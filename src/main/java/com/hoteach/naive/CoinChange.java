package com.hoteach.naive;

import com.google.common.collect.Lists;

import javax.sound.midi.Soundbank;
import java.util.*;

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


    public int coinChange(List<Integer> coins, Integer money, Map<Integer, Integer> cache, List<Integer> path) {


        Integer integer = cache.get(money);
        if (Objects.nonNull(integer)) {
            return integer;
        }

        if (money == 0) return 0;
        if (money < 0) return -1;

        int temp = Integer.MAX_VALUE;

        for (Integer coin : coins) {
            int result = coinChange(coins, money - coin, cache, path);
            if (result == -1) {
                continue;
            }
            if (result + 1 < temp) {
                path.add(coin);
                temp = result + 1;
            }
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


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        long l = System.currentTimeMillis();
        List<Integer> path = Lists.newArrayList();
        int i = coinChange.coinChange(Arrays.asList(1, 3, 5, 6, 11), 11);
        System.out.println(i);
        System.out.println(path);
    }

}
