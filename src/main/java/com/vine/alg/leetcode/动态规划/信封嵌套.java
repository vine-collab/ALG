package com.vine.alg.leetcode.动态规划;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author 阿季
 * @date 2021-05-17 17:01
 */

public class 信封嵌套 {


    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int[] ints = Stream.of(envelopes).map(e -> e[1]).mapToInt(a -> a).toArray();


        LIS最长递增子序列 lis最长递增子序列 = new LIS最长递增子序列();
        int i = lis最长递增子序列.lengthOfLIS(ints);
        return i;


    }


    public static void main(String[] args) {
        信封嵌套 c = new 信封嵌套();
        int[][] ints = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int i = c.maxEnvelopes(ints);
        System.out.println(i);
    }

}
