package com.vine.naive.动态规划;

import org.apache.commons.lang3.tuple.Pair;

/**
 * reference：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=4&sn=83fdd556c0d7c638b7a0df72129c0268&chksm=9bd7fb33aca07225f0528761352f1767de44debe2bf5210245f3d2d17b7ec23a70ef574505ef&scene=21#wechat_redirect
 *
 * @author 博弈问题
 * @date 2021-05-24 19:51
 */

public class 博弈问题 {


    int stoneGame(int[] piles) {
        int length = piles.length;
        Pair[][] dp = new Pair[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = Pair.of(0, 0);
            }
        }
        for (int i = 0; i < length; i++) {
            dp[i][i] = Pair.of(piles[i], 0);
        }

        // 斜着遍历
        for (int k = 2; k <= length; k++) {
            for (int i = 0; i <= length - k; i++) {
                int j = k + i - 1;
                // 先手左边，和右边的分数
                int left = piles[i] + (Integer) dp[i + 1][j].getRight();
                int right = piles[j] + (Integer) dp[i][j - 1].getRight();
                if (left > right) {
                    dp[i][j] = Pair.of(left, dp[i + 1][j].getLeft());
                } else {
                    dp[i][j] = Pair.of(right, dp[i][j - 1].getLeft());
                }
            }

        }

        return (Integer) dp[0][length - 1].getLeft() - (Integer) dp[0][length - 1].getRight();
    }

    public static void main(String[] args) {
        博弈问题 c = new 博弈问题();
        int i = c.stoneGame(new int[]{3, 9, 1, 2});
        System.out.println(i);
    }


}
