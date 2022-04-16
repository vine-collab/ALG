package com.vine.alg.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-04-16 3:19 PM
 */

public class 最小插入次数构造回文串 {

    public static void main(String[] args) {
        try {
            最小插入次数构造回文串 z = new 最小插入次数构造回文串();
            int i = z.dp("a");
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    int dp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Integer.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1);
                }
            }
        }


        return dp[0][n - 1];
    }
}










