package com.vine.alg.code.leetcode;

import sun.security.rsa.RSAKeyFactory;

/**
 * @author 阿季
 * @date 2023-04-03 8:43 PM
 */

public class $516_最长回文子序列 {

    /**
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * <p>
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "bbbab"
     * 输出：4
     * 解释：一个可能的最长回文子序列为 "bbbb" 。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出：2
     * 解释：一个可能的最长回文子序列为 "bb" 。
     * <p>
     * 链接：https://leetcode.cn/problems/longest-palindromic-subsequence
     */

    public static void main(String[] args) {
        $516_最长回文子序列 z = new $516_最长回文子序列();
        int cbbd = z.longestPalindromeSubseq("cbbd");
        System.out.println(cbbd);
    }

    // dp(i,j) 表示在s(i,j)中的最长回文序列
    public int longestPalindromeSubseq(String s) {

        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            dp[i][i] = 1;
        }



        for (int i = l - 1; i >= 0; i--) {
            for(int j = i + 1; j < l; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }


        return dp[0][l - 1];


    }

}































































