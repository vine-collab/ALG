package com.vine.alg.双指针技巧套路框架.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-10 8:52 PM
 */

public class 字符串排列 {
    public static void main(String[] args) {
        try {
            字符串排列 z = new 字符串排列();
            boolean b = z.checkInclusion("helloword", "oow");
            System.out.println(b);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
        判断 s 中是否有 t的排列
     */
    boolean checkInclusion(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.toCharArray().length; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
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
                    return true;
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


        return false;
    }
}

















