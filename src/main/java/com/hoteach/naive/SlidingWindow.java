package com.hoteach.naive;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
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
        return len == Integer.MAX_VALUE ? null : source.substring(start, len);


    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        String s = slidingWindow.minWindow("abcdcc", "bac");
        System.out.println(s);
    }

}
