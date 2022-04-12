package com.vine.alg.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-04-12 9:34 PM
 */

public class 二维递增子序列_信封嵌套问题 {


    public static void main(String[] args) {
        try {
            二维递增子序列_信封嵌套问题 z = new 二维递增子序列_信封嵌套问题();
            int i = z.maxEnvelope(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
        按照宽进行逆序排排列，在按照长寻找递增子序列的个数
     */
    int maxEnvelope(int[][] envelopes) {

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }



        return Arrays.stream(dp).max().getAsInt();
    }


}
