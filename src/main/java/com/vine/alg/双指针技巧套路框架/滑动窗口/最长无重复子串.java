package com.vine.alg.双指针技巧套路框架.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-11 10:00 PM
 */

public class 最长无重复子串 {
    public static void main(String[] args) {
        最长无重复子串 z = new 最长无重复子串();
        int aabab = z.lengthOfLongestSubstring("aabcdab");
        System.out.println(aabab);
    }


    int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        // 初始化指针位置
        int left = 0, right = 0;
        int len = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) { // 存在重复字符的
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }

            len = Integer.max(len, right - left); // 所以要在这里更新结果

        }


        return len;

    }


}
