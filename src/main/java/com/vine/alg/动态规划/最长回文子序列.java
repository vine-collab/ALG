package com.vine.alg.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-04-16 11:29 AM
 */

public class 最长回文子序列 {
    public static void main(String[] args) {
        try {
            最长回文子序列 z = new 最长回文子序列();
            int i = z.longestPalindromeSubSeq("abda");
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*  dp[i][j] 表示在子串s[i...j] 中最长回文子序列dp[i][j]
        状态转移
        if(s[i] == s[j]){
            dp[i][j] = dp[i][j] + 2
        } else {
            dp[i][j] = max{dp[i + 1][j], dp[i][j - 1]}
        }
     */
    int longestPalindromeSubSeq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        for (int i = 0; i < length; i++) {
            // 只有一个字符的时候，回文序列长度是1
            dp[i][i] = 1;
        }

        // 反向遍历数组 i 表示纵向，j表示横向
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[0][length - 1];

    }

}
