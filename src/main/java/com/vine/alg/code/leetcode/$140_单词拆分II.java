package com.vine.alg.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2023-08-23 09:25
 */

public class $140_单词拆分II {



    /**
     * 140. 单词拆分 II
     * 困难
     * 712
     * 相关企业
     * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
     *
     * 注意：词典中的同一个单词可能在分段中被重复使用多次。
     *
     *
     *
     * 示例 1：
     *
     * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * 输出:["cats and dog","cat sand dog"]
     * 示例 2：
     *
     * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
     * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * 解释: 注意你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * 输出:[]
     *
     * https://leetcode.cn/problems/word-break-ii/description/
     *
     */

    public static void main(String[] args) {
        $140_单词拆分II z = new $140_单词拆分II();
        List<String> strings = z.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(strings);
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        backtrack(new LinkedList(), 0);
        return res;
    }

    String s;
    List<String> wordDict;
    List<String> res = new ArrayList<>();

    // i 表示匹配的长度
    void backtrack(LinkedList track, int i) {
        if(i == s.length()) {
            res.add(String.join(" ", track));
            return;
        }

        if(i >= s.length()) {
            return;
        }

        for(String str : wordDict) {

            int len = str.length();
            // 超长了
            if(i + len > s.length()) {
                continue;
            }
            if(!s.substring(i, i + len).equals(str)) {
                continue;
            }

            track.addLast(str);

            backtrack(track, i + len);
            track.removeLast();
        }

    }

}































































