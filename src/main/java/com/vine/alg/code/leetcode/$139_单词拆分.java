package com.vine.alg.code.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-06-26 3:28 PM
 */

public class $139_单词拆分 {


    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     * 注意，你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/word-break
     */

    public static void main(String[] args) {
        $139_单词拆分 d = new $139_单词拆分();
        boolean b = d.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(b);


    }


    public boolean wordBreak(String s, List<String> wordDict) {
        this.word = s;
        this.wordDict = wordDict;
//        return backtrack(new StringBuilder());
        return dp(s, 0);
    }

    String word;

    List<String> wordDict;

    boolean backtrack(StringBuilder cur) {
        if (word.equals(cur.toString())) {
            return true;
        }

        if (!word.startsWith(cur.toString())) {
            return false;
        }

        if (cur.length() > word.length()) {
            return false;
        }

        for (String s : wordDict) {
            cur.append(s);
            if (backtrack(cur)) {
                return true;
            }
            cur.delete(cur.length() - s.length(), cur.length());
        }
        return false;
    }


    Map<Integer, Boolean> memo = new HashMap<>();


    /**
     * 表示s[i..] 是否能被拼出
     */
    boolean dp(String word, int i) {
        if (i == word.length()) {
            return true;
        }

        Boolean m = memo.get(i);
        if(m != null) {
            return m;
        }


        for (String s : wordDict) {
            if (word.substring(i).startsWith(s)) {
                boolean dp = dp(word, i + s.length());
                if (dp) {
                    memo.put(i, dp);
                    return true;
                }
            }
        }

        memo.put(i, Boolean.FALSE);
        return false;


    }


}

































