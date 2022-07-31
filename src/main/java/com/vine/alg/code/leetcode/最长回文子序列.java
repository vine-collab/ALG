package com.vine.alg.code.leetcode;

/**
 * 516. 最长回文子序列
 *
 * @author 阿季
 * @date 2021-06-09 16:44
 */

public class 最长回文子序列 {

    public int longestPalindromeSubseq(String s) {

        // dp[i][j]：表示s[i...j] 的最长回文子序列的长度为dp[i][j], 目标结果是dp[0][s.length()-1]
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            // i==j 时 肯定是回文，i > j 时不存在默认为0
            dp[i][i] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        最长回文子序列 c = new 最长回文子序列();
        int bbbab = c.longestPalindromeSubseq("bbcbab");
        System.out.println(bbbab);
    }


}
