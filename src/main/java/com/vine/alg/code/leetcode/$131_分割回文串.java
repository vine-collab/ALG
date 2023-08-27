package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2023-08-15 20:53
 */

public class $131_分割回文串 {

    public static void main(String[] args) {
        $131_分割回文串 z = new $131_分割回文串();
        List<List<String>> aab = z.partition("aab");
        System.out.println(JSON.toJSONString(aab));

    }


    /**
     * https://leetcode.cn/problems/palindrome-partitioning/
     * <p>
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * <p>
     * 回文串 是正着读和反着读都一样的字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * <p>
     * 输入：s = "a"
     * 输出：[["a"]]
     */

    public List<List<String>> partition(String s) {
        this.s = s;
        backtrack(0, new LinkedList());
        return res;
    }

    List<List<String>> res = new ArrayList<>();

    String s;

    void backtrack(int start, LinkedList track) {
        if (start == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }


        for (int i = start; i < s.length(); i++) {
            if (!valid(start, i)) {
                continue;
            }
            track.addLast(s.substring(start, i + 1));
            backtrack(i + 1, track);
            track.removeLast();
        }
    }


    boolean valid(int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}































































