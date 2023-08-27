package com.vine.alg.code.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-08-13 6:13 PM
 */

public class $32_最长有效括号 {

    public static void main(String[] args) {
        $32_最长有效括号 z = new $32_最长有效括号();
        int i = z.longestValidParentheses("(()");
        System.out.println(i);
    }


    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        // 以si-1结尾的最长有效括号长度为dpi
        int dp[] = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {

                // 遇到右括号
                if (!stk.isEmpty()) {
                    // 获取与之匹配的左括号索引
                    int leftIndex = stk.pop();
                    // 以这个右括号结尾的最长子串长度, 本次匹配的长度 + 匹配前面一个字符结尾的有效括号的长度
                    int len = (i - leftIndex + 1) + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    dp[i + 1] = 0;
                }
            }

        }
        return Arrays.stream(dp).max().getAsInt();

    }


    public int longestValidParentheses1(String s) {
        //dp(i) 表示以s(i - 1) 结尾的字符串中最长有效括号的长度
        int[] dp = new int[s.length() + 1];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i);
                dp[i + 1] = 0; // 左括号不能匹配
            } else {
                // 遇到右括号
                if(stk.isEmpty()) { //无法匹配
                    dp[i + 1] = 0;
                } else {
                    Integer leftIdx = stk.pop();
                    int len = 1 + i - leftIdx; // 当前匹配的括号的长度
                    dp[i + 1] = len + dp[leftIdx]; // 加上匹配之前的那个字符串结尾的长度
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }


}































































