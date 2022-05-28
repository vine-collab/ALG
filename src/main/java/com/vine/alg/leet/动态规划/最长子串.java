package com.vine.alg.leet.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2021-05-19 15:54
 */

public class 最长子串 {


    /**
     * 最长不重复子串
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, len = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.getOrDefault(c, 0) > 1) {
                char l = s.charAt(left);
                left++;
                window.put(l, window.get(l) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }



    /**
     * 最长不重复子串
     *
     * @param s
     * @return
     */
    // public int lengthOfLongestSubstring(String s) {
    //     if (Objects.isNull(s) || s.length() == 0) {
    //         return 0;
    //     }
    //     int[] dp = new int[s.length()];
    //     Arrays.fill(dp, 1);
    //     for (int i = 1; i < s.length(); i++) {
    //         String substring = s.substring(0, i);
    //         if (substring.contains(s.charAt(i) + "")) {
    //             dp[i] = Math.max(dp[i - 1], dp[i]);
    //         } else {
    //             dp[i] = dp[i - 1] + 1;
    //         }
    //     }
    //
    //
    //     return Arrays.stream(dp).max().getAsInt();
    // }

    public static void main(String[] args) {
        最长子串 c = new 最长子串();
        int i = c.lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}
