package com.vine.alg.code.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-04-23 11:58 AM
 */

public class 最长有效括号 {
    public static void main(String[] args) {
        最长有效括号 z = new 最长有效括号();
        int i = z.longestValidParentheses("()(())");
        System.out.println(i);

    }

    /*
        给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。

        示例 1：

        输入：s = "(()"
        输出：2
        解释：最长有效括号子串是 "()"
        示例 2：

        输入：s = ")()())"
        输出：4
        解释：最长有效括号子串是 "()()"
        示例 3：

        输入：s = ""
        输出：0

        提示：

        0 <= s.length <= 3 * 104
        s[i] 为 '(' 或 ')'

     */
    public int longestValidParentheses(String s) {

        return dp(s);

    }


    int dp(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] - 1 >= 1) {
                        // 前一个匹配 + 当前匹配 + 前一个的前一个位置
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 1 - 1];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
        }


         return Arrays.stream(dp).max().getAsInt();
    }

    int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int count = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.empty()) {
                    count = 0;
                } else if (stack.peek() == '(') {
                    stack.pop();
                    count += 2;
                    res = Integer.max(res, count);
                }

            }

        }

        return res;
    }


}









