package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-06-17 8:57 PM
 */

public class $583_两个字符串的删除操作 {


    /**
     * https://leetcode.cn/problems/delete-operation-for-two-strings/
     * <p>
     * 给定两个单词word1和word2，返回使得word1和word2相同所需的最小步数。
     * <p>
     * 每步可以删除任意一个字符串中的一个字符。
     * <p>
     * 示例 1：
     * <p>
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     * <p>
     * 示例 2:
     * 输入：word1 = "leetcode", word2 = "etco"
     * 输出：4
     */
    public static void main(String[] args) {
        $583_两个字符串的删除操作 l = new $583_两个字符串的删除操作();
        int leetcode = l.dp("a", "b");
        System.out.println(leetcode);
    }

    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length() - 1, word2.length() - 1);
    }


    /**
     * 表示 s1[0,i]->s2[0,j] 的最短编辑距离
     */
    int minDistance(String s1, String s2, int i, int j) {

        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i +1;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return minDistance(s1, s2, i - 1, j - 1);
        }

        return Integer.min(minDistance(s1, s2, i - 1, j) + 1, minDistance(s1, s2, i, j - 1) + 1);


    }



    int dp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // s1[0,i-1] -> s2[0,j-1] 的最短编辑距离 为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 删除s1, 删除s2
                    dp[i][j] = Integer.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }

            }
        }

        return dp[m][n];


    }


}


























