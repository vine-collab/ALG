package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-06-20 9:22 PM
 */

public class $22_括号生成 {


    /**
     * https://leetcode.cn/problems/generate-parentheses/
     * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/generate-parentheses
     */
    public static void main(String[] args) {
        $22_括号生成 k = new $22_括号生成();
        List<String> strings = k.generateParenthesis1(3);
        System.out.println(JSON.toJSONString(strings));

    }

    public List<String> generateParenthesis(int n) {
        backtrack(n, "");
        return res;
    }

    List<String> res = new ArrayList<>();

    void backtrack(int n, String cur) {
        if (cur.length() == 2 * n) {
            if (valid(cur)) {
                res.add(new String(cur));
            }
            return;
        }

        backtrack(n, cur + "(");
        backtrack(n, cur + ")");
    }

    boolean isValid(String cur) {
        Stack<Character> s = new Stack<>();
        for (char c : cur.toCharArray()) {
            if (s.isEmpty()) {
                s.push(c);
            } else if (s.peek() == ')') {
                return false;
            } else if (c == ')' && s.peek() == '(') {
                s.pop();
            } else {
                s.push(c);
            }

        }
        return s.isEmpty();
    }


    public List<String> generateParenthesis1(int n) {
        this.n = n;
        backtrack(new LinkedList<String>());
        return res;
    }

    int n;
    void backtrack(LinkedList<String> track) {
        if(track.size() == 2 * n) {
            String join = String.join("", track);
            if(valid(join)) {
                res.add(join);
            }
            return;
        }

        track.addLast(")");
        backtrack(track);
        track.removeLast();
        track.addLast("(");
        backtrack(track);
        track.removeLast();


    }
    boolean valid(String s) {
        int left = 0, right = 0;

        for(char c : s.toCharArray()) {
            if(c == ')') {
                right++;
            }
            if(c == '(') {
                left++;
            }
            if(right > left) {
                return false;
            }
        }
        return left == right;
    }


}















