package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-06-17 8:20 PM
 */

public class $1143_最长公共子序列 {


    /**
     * https://leetcode.cn/problems/longest-common-subsequence/
     *
     * @param args
     */
    public static void main(String[] args) {
        $1143_最长公共子序列 z = new $1143_最长公共子序列();
        z.longestCommonSubsequence("abcde", "ace");
    }

    /**
     * 表示0..i - 1 和 0..j - 1 的最长公共子序列的长度为 dp
     * base case 字符串为空字符时，dp[0][0] = 0;
     * 结果在dp[n][m];
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];


    }

}
