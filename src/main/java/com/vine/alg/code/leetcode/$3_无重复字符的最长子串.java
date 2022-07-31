package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-05-01 4:07 PM
 */

public class $3_无重复字符的最长子串 {




    /*
    3. 无重复字符的最长子串
    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public static void main(String[] args) {
        $3_无重复字符的最长子串 z = new $3_无重复字符的最长子串();
        int abcabcbb = z.lengthOfLongestSubstring("abcabcdbb");
        System.out.println(abcabcbb);
    }

    /*
     滑动窗口解法：

     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int left = 0;
        int right = 0;
        int len = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < length) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }

            len = Integer.max(len, right - left);
        }

        return len;
    }
}














