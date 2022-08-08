package com.vine.alg.code.topcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-08-08 9:50 PM
 */

public class $22_括号生成 {


    public static void main(String[] args) {
        com.vine.alg.code.leetcode.$22_括号生成 k = new com.vine.alg.code.leetcode.$22_括号生成();
        List<String> strings = k.generateParenthesis(3);
        System.out.println(JSON.toJSONString(strings));

    }

    public List<String> generateParenthesis(int n) {
        backtrack(n, "");
        return res;
    }

    List<String> res = new ArrayList<>();

    void backtrack(int n, String cur) {
        if (cur.length() == 2 * n && isValid(cur)) {
            res.add(new String(cur));
            return;
        }
        backtrack(n, cur + '(');
        backtrack(n , cur + ')');
    }

    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == ')') {
                    return false;
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return s.isEmpty();
    }


}































































