package com.vine.alg.code.topcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-07-31 2:59 PM
 */

public class $72_编辑距离 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        $72_编辑距离 b = new $72_编辑距离();
        int i = b.minDistance1("horse", "ros");
        System.out.println(i);


    }


    public int minDistance(String word1, String word2) {
        return minDistanceMemo(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    Map<String, Integer> memo = new HashMap<>();


    /**
     * 表示s1[0, i]-> s2[0, j] 的最短距离
     * base case
     * i = -1, or j = -1
     * <p>
     * distance = min{插入，删除，替换}
     */
    public int minDistanceMemo(String s1, int p1, String s2, int p2) {

        if (p1 < 0) {
            return p2 + 1;
        }

        if (p2 < 0) {
            return p1 + 1;
        }

        String key = getKey(p1, p2);
        Integer v = memo.get(key);
        if (v != null) {
            return v;
        }
        int res;

        if (s1.charAt(p1) == s2.charAt(p2)) {
            res = minDistanceMemo(s1, p1 - 1, s2, p2 - 1);
        } else {
            // 插入
            int insert = minDistanceMemo(s1, p1, s2, p2 - 1);
            // 删除
            int delete = minDistanceMemo(s1, p1 - 1, s2, p2);
            // 替换
            int replace = minDistanceMemo(s1, p1 - 1, s2, p2 - 1);
            res = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        memo.put(key, res);
        return res;

    }

    String getKey(int i, int j) {
        return i + "_" + j;
    }


    /**
     * dp[i][j] 表示 s1[i - 1][j - 1] 的最小编辑距离
     * 定义：s1[0..i] 和 s2[0..j] 的最小编辑距离是 dp[i+1][j+1]
     */
    public int minDistance1(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // dp[i][j] 表示 s1[i - 1][j - 1] 的最小编辑距离
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];

    }


}































































