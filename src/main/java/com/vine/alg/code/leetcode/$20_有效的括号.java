package com.vine.alg.code.leetcode;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-07-25 9:56 PM
 */

public class $20_有效的括号 {

    public static void main(String[] args) {
        $20_有效的括号 y = new $20_有效的括号();
        boolean valid = y.isValid("()");
        System.out.println(valid);
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else
                if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else
                if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();


    }


}































































