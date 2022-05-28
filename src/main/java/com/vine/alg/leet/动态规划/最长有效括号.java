package com.vine.alg.leet.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2021-05-31 20:35
 */

public class 最长有效括号 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // dp表示以s.charAt(i)结尾的字符串中连续括号的对数, "(" 的位置为0
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

            }
        }

        return Arrays.stream(dp).max().getAsInt();

    }

    public static void main(String[] args) {
        最长有效括号 c = new 最长有效括号();
        int i = c.longestValidParentheses("()(())");
        System.out.println(i);
    }
}
