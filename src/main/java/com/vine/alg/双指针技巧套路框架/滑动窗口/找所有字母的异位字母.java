package com.vine.alg.双指针技巧套路框架.滑动窗口;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-11 9:19 PM
 */

public class 找所有字母的异位字母 {

    public static void main(String[] args) {
        try {
            找所有字母的异位字母 z = new 找所有字母的异位字母();
            List<Integer> anagrams = z.findAnagrams("cbaebabacd", "abc");
            System.out.println(JSON.toJSONString(anagrams));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.toCharArray().length; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 初始化指针位置
        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }


                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }


        }


        return result;
    }
}
