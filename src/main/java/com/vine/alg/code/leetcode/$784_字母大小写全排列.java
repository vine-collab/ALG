package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2022-06-06 8:48 PM
 */

public class $784_字母大小写全排列 {

    /**
     * https://leetcode.cn/problems/letter-case-permutation/
     * <p>
     * 784. 字母大小写全排列
     * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
     * <p>
     * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     * 示例 2:
     * <p>
     * 输入: s = "3z4"
     * 输出: ["3z4","3Z4"]
     */

    public static void main(String[] args) {
        $784_字母大小写全排列 z = new $784_字母大小写全排列();
        List<String> a1b2 = z.letterCasePermutation("a1b2");
        System.out.println(JSON.toJSONString(a1b2));
    }

    public List<String> letterCasePermutation(String s) {
        backtrack(s.toCharArray(), 0, new LinkedList());
        return res;
    }

    List<String> res = new ArrayList<>();

    void backtrack(char[] chars, int pos, LinkedList<Character> cur) {

        if (chars.length == cur.size()) {
            String s = cur.stream().map(String::valueOf).collect(Collectors.joining());
            res.add(s);
            return;
        }

        for (int i = pos; i < chars.length; i++) {

            char ch = chars[i];

            cur.addLast(ch);
            backtrack(chars, i + 1, cur);
            cur.removeLast();

            if (Character.isDigit(ch)) {
                continue;
            }
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
                cur.addLast(ch);
                backtrack(chars, i + 1, cur);
                cur.removeLast();
            } else {
                ch = Character.toUpperCase(ch);
                cur.addLast(ch);
                backtrack(chars, i + 1, cur);
                cur.removeLast();
            }
        }


    }

}















