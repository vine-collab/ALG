package com.hoteach.naive;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 滑动窗口
 *
 * @author 阿季
 * @date 2021-04-29 19:26
 */

public class SlidingWindow {

    public String minWindow(String source, String target) {

        int left = 0, right = 0, valid = 0, len = Integer.MAX_VALUE, start = 0;

        Map<Character, Long> windowMap = new HashMap<>();
        Map<Character, Long> targetMap = target.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Character::valueOf, Collectors.counting()));

        while (right < source.length()) {
            char c = source.charAt(right);
            right++;
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0L) + 1);
                if (windowMap.getOrDefault(c, 0L) == targetMap.getOrDefault(c, 0L)) {
                    valid++;
                }
            }

            while (valid == targetMap.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = source.charAt(left);
                left++;
                if (targetMap.containsKey(d)) {
                    if (windowMap.get(d) == targetMap.get(d)) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? null : source.substring(start, len + 1);


    }


    public String minStr(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.toCharArray().length; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int start = 0, left = 0, right = 0, valid = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (Objects.equals(window.get(l), need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }

        }


        return len == Integer.MAX_VALUE ? null : s.substring(start, len + 1);
    }


    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        String s = slidingWindow.minWindow("bxacdcc", "bac");
        System.out.println(s);
    }

}
