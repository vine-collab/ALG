package com.vine.alg.code.动态规划;

/**
 * @author 阿季
 * @date 2021-06-02 17:22
 */

public class 最小代价构造回文串 {

    int minInsertions(String s) {

        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }

        // dp: s[i...j] 的字符串构造成回文的最小代价为dp[i][j], base case
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // min{左边插入一个，右边插入一个} + 1
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }


    public static void main(String[] args) {
        最小代价构造回文串 c = new 最小代价构造回文串();
        int abacd = c.minInsertions("a");
        System.out.println(abacd);
    }


}
