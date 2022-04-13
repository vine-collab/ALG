package com.vine.alg.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-13 9:18 PM
 */

public class 最长公共子序列 {


    public static void main(String[] args) {
        try {
            最长公共子序列 z = new 最长公共子序列();
            String s1 = "abcde131213", s2 = "aceb133";
            int i = z.longestCommonSubsequence(s1, s2, s1.length() - 1, s2.length() - 1);
            System.out.println(i);
            int i1 = z.longestCommonSubsequenceMemo(s1, s2, s1.length() - 1, s2.length() - 1, new HashMap<>());
            System.out.println(i1);
            int i2 = z.dp(s1, s2);
            System.out.println(i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        分析：如果s1[i] == s2[j] 则表明 这个字符在公共子序列lcs中，则lcs长度+1，去判断下一个字符
        如果 s1[i] != s2[j] 则表明至少有一个字符不在lcs中， 递归下一个字符， 取最大值
        可以用备忘录降，或者dp数组的方式 低时间复杂度
     */
    int longestCommonSubsequence(String s1, String s2, int pos1, int pos2) {
        if (pos1 == -1 || pos2 == -1) {
            return 0;
        }
        if (s1.charAt(pos1) == s2.charAt(pos2)) {
            return longestCommonSubsequence(s1, s2, pos1 - 1, pos2 - 1) + 1;
        } else {
            return Integer.max(longestCommonSubsequence(s1, s2, pos1 - 1, pos2), longestCommonSubsequence(s1, s2, pos1, pos2 - 1));
        }
    }

    int longestCommonSubsequenceMemo(String s1, String s2, int pos1, int pos2, Map<String, Integer> memo) {
        if (memo.get(pos1 + "_" + pos2) != null) {
            return memo.get(pos1 + "_" + pos2);
        }

        if (pos1 == -1 || pos2 == -1) {
            return 0;
        }
        if (s1.charAt(pos1) == s2.charAt(pos2)) {
            int i = longestCommonSubsequenceMemo(s1, s2, pos1 - 1, pos2 - 1, memo) + 1;
            memo.put(pos1 + "_" + pos2, i);
            return i;
        } else {
            int max = Integer.max(longestCommonSubsequenceMemo(s1, s2, pos1 - 1, pos2, memo), longestCommonSubsequenceMemo(s1, s2, pos1, pos2 - 1, memo));
            memo.put(pos1 + "_" + pos2, max);
            return max;
        }
    }


    int dp(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }


}
