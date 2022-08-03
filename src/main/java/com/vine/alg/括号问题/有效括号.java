package com.vine.alg.括号问题;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-07-31 9:32 PM
 */

public class 有效括号 {


    boolean isValid1(String s) {
        // 待匹配左括号的数量
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                // 遇到右括号
                left--;
            }

            // 右括号太多
            if (left == -1) {
                return false;
            }

        }
        // 是否所有括号都被匹配了
        return left == 0;

    }

    boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            // c是左括号
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            }
            // c是右括号
            else {
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                }
                // 和栈顶的左括号不匹配
                else {
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }


    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }


}































































