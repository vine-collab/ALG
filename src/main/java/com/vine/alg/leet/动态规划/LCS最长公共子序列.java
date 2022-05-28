package com.vine.alg.leet.动态规划;

/**
 * @author 阿季
 * @date 2021-05-18 20:38
 */

public class LCS最长公共子序列 {


    int longestCommonSequence(String s1, String s2, int start1, int start2) {
        for (int i = start1; i >= 0; i--) {
            for (int j = start2; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    return longestCommonSequence(s1, s2, i - 1, j - 1) + 1;
                } else {
                    return Math.max(longestCommonSequence(s1, s2, i - 1, j), longestCommonSequence(s1, s2, i, j - 1));
                }
            }
        }


        return 0;
    }


    int dp(String s1, String s2) {
        // dp[i][j]的含义是：对于s1[1..i]和s2[1..j]，它们的 LCS 长度是dp[i][j]
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        LCS最长公共子序列 c = new LCS最长公共子序列();
        String s1 = "abcdef";
        String s2 = "acfe";
        int start1 = s1.length() - 1;
        int start2 = s2.length() - 1;
        int i = c.longestCommonSequence(s1, s2, start1, start2);
        System.out.println(i);
        System.out.println("-----------------");
        int dp = c.dp(s1, s2);
        System.out.println(dp);
    }

}
