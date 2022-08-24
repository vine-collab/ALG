package com.vine.alg.code.leetcode;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-08-18 8:58 PM
 */

public class $394_字符串解码 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * <p>
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * <p>
     * 链接：https://leetcode.cn/problems/decode-string
     */
    public static void main(String[] args) {
        $394_字符串解码 z = new $394_字符串解码();

        String s = z.decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }

    public String decodeString(String s) {

        Stack<Character> stk = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stk.push(c);
            } else {
                StringBuilder cur = new StringBuilder();
                while (stk.peek() != '[') {
                    cur.append(stk.pop());
                }
                stk.pop(); // 弹出 [
                StringBuilder count = new StringBuilder();

                while (!stk.isEmpty() && stk.peek() >= '0' && stk.peek() <= '9') {
                    count.append(stk.pop());
                }

                int n = Integer.parseInt(count.reverse().toString());
                String temp = cur.reverse().toString();
                for (int i = 0; i < n; i++) {
                    push(temp, stk);
                }

            }
        }
        StringBuilder cur = new StringBuilder();
        while (!stk.isEmpty()) {
            cur.append(stk.pop());
        }
        res.append(cur.reverse());
        return res.toString();
    }


    void push(String s, Stack<Character> stk) {
        for (char c : s.toCharArray()) {
            stk.push(c);
        }
    }
}































































