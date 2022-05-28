package com.vine.alg.leet.动态规划;

/**
 *
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484666&idx=1&sn=e3305be9513eaa16f7f1568c0892a468&chksm=9bd7faf2aca073e4f08332a706b7c10af877fee3993aac4dae86d05783d3d0df31844287104e&scene=21#wechat_redirect
 * @author 阿季
 * @date 2021-05-18 17:46
 */

public class 最长回文序列 {


    int longestPalindromeSubSequence(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                // 状态转移
                if (s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // 整个 s 的最长回文子串长度
        return dp[0][s.length() - 1];
    }


    public static void main(String[] args) {
        最长回文序列 c = new 最长回文序列();

        int i = c.longestPalindromeSubSequence("2312");
        System.out.println(i);
    }

}
