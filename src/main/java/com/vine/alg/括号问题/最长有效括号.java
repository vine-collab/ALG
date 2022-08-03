package com.vine.alg.括号问题;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-08-01 9:45 PM
 */

public class 最长有效括号 {

    /**
     * https://leetcode.cn/problems/longest-valid-parentheses/
     *
     * @param args
     */
    public static void main(String[] args) {
        最长有效括号 z = new 最长有效括号();
        System.out.println(z.longestValidParentheses("(()"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();

        int[] dp = new int[s.length() + 1]; // 以s[i - 1] 结尾最长合法括号长度为dp[i]
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i); // 遇到左括号记录索引
                dp[i + 1] = 0; // 有效括号不可能以左括号结尾
            }

            else {
                if(!stk.isEmpty()) {
                    Integer leftIndex = stk.pop(); // 匹配左括号对应的索引
                    // 以这个右括号结尾的最长子串长度, dp[leftIndex] 正好比s[i]偏移一位，表示s[i-1]结尾的最长长度，
                    // 计算栈顶元素前面一个元素为结尾的有效括号的长度
                    int len = 1 + i - leftIndex + dp[leftIndex];
                    dp[i + 1] = len;
                }
                // 没有对应的左括号
                else {
                    dp[i + 1] = 0;
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();


    }

}































































