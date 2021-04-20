package com.hoteach.naive;

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


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        long l = System.currentTimeMillis();
        int i = coinChange.coinChange(Arrays.asList(1, 3, 5, 6), 110, new HashMap<>());
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(i);
    }

}
