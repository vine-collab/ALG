package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-06-16 9:00 PM
 */

public class $72_编辑距离 {

    public static void main(String[] args) {
        $72_编辑距离 b = new $72_编辑距离();
        int i = b.dp("intention", "execution");
        System.out.println(i);
    }

    /**
     * https://leetcode.cn/problems/edit-distance/
     * <p>
     * 72. 编辑距离
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     * <p>
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     */
    public int minDistance(String word1, String word2) {

        return distance(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    /*
    表示s1[0, i]-> s2[0, j] 的最短距离
    base case
    i = -1, or j = -1

    distance = min{插入，删除，替换}
     */

    Map<String, Integer> memo = new HashMap<>();


    public int distance(String s1, int i, String s2, int j) {

        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        // 相同
        if (s1.charAt(i) == s2.charAt(j)) {
            return distance(s1, i - 1, s2, j - 1);
        }
        // 插入
        int insert = distance(s1, i, s2, j - 1) + 1;
        // 删除
        int delete = distance(s1, i - 1, s2, j) + 1;
        // 修改
        int modify = distance(s1, i - 1, s2, j - 1) + 1;

        int min = Integer.min(Integer.min(insert, delete), modify);
        memo.put(key, min);
        return min;
    }


    /*
    表示 s1[0,i]->s2[0,j] 的编辑距离
     */
    int dp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.min(Integer.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1), dp[i][j - 1] + 1);
                }
            }
        }
        return dp[n][m];


    }


}
