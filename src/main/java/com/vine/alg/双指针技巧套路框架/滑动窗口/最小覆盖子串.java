package com.vine.alg.双指针技巧套路框架.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-10 5:49 PM
 */

public class 最小覆盖子串 {
    public static void main(String[] args) {
        最小覆盖子串 z = new 最小覆盖子串();
        String s = z.minWindow("abcdc", "db");
        System.out.println(s);
    }

    String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            need.put(s.charAt(i), need.getOrDefault(s.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        // 其中valid变量表示窗口中满足need条件的字符个数，如果valid和need.size的大小相同，则说明窗口已满足条件，已经完全覆盖了串T
        int valid = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            // 窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将要移出的字符
                char d = s.charAt(left);
                // 左侧窗口右移
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }

        }


        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, len);
    }

}














