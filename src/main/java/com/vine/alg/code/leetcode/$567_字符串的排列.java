package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-10-22 5:00 PM
 */

public class $567_字符串的排列 {


    /**
     * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * <p>
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     * <p>
     * 链接：https://leetcode.cn/problems/permutation-in-string
     */
    public static void main(String[] args) {
        $567_字符串的排列 z = new $567_字符串的排列();
        boolean b = z.checkInclusion("eidbaooo", "ab");
        System.out.println(b);
    }

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> window = new HashMap<>();

        Map<Character, Integer> need = new HashMap<>();

        for (char c : s2.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int right = 0, left = 0, valid = 0;

        while (right < s1.length()) {
            char c = s1.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if(right - left == s2.length()) {
                    return true;
                }
                char d = s1.charAt(left);
                left++;

                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;


    }





    public boolean checkInclusion1(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while(right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while(right - left >= s1.length()) {
                if(valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)) {
                    if(need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);

                }
            }



        }
        return false;
    }

}































































