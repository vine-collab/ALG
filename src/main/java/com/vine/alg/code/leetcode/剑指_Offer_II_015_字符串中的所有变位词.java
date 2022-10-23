package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import javafx.concurrent.Worker;

import javax.xml.bind.util.JAXBSource;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-10-23 5:34 PM
 */

public class 剑指_Offer_II_015_字符串中的所有变位词 {


    /**
     * 给定两个字符串s和p，找到s中所有 p 的变位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 变位词 指字母相同，但排列不同的字符串。
     * <p>
     *
     * <p>
     * 示例1：
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
     * 示例 2：
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
     * <p>
     * 链接：https://leetcode.cn/problems/VabMRr
     */
    public static void main(String[] args) {
        剑指_Offer_II_015_字符串中的所有变位词 j = new 剑指_Offer_II_015_字符串中的所有变位词();
        List<Integer> anagrams = j.findAnagrams("cbaebabacd", "abc");
        System.out.println(JSON.toJSONString(anagrams));

    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return res;
    }


}































































