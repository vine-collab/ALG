package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 阿季
 * @date 2023-10-28 5:04 PM
 */

public class $1358_包含所有三种字符的子字符串数目 {


    /**
     * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
     * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
     * <p>
     * 示例 1：
     * 输入：s = "abcabc"
     * 输出：10
     * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
     * <p>
     * 示例 2：
     * 输入：s = "aaacb"
     * 输出：3
     * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
     * <p>
     * 示例 3：
     * 输入：s = "abc"
     * 输出：1
     */
    public static void main(String[] args) {
        $1358_包含所有三种字符的子字符串数目 z = new $1358_包含所有三种字符的子字符串数目();
        int abcabc = z.numberOfSubstrings("aaacb");
        System.out.println(abcabc);
    }

    public int numberOfSubstrings(String s) {
        int left = 0, right = 0, res = 0, valid = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        target.put('a', 1);
        target.put('b', 1);
        target.put('c', 1);

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (c >= 'a' && c <= 'c') {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    valid++;
                }
            }

            while (valid == 3) {
                char d = s.charAt(left);
                left++;
                res += s.length() - right + 1;
                window.put(d, window.get(d) - 1);
                if (window.get(d) == 0) {
                    valid--;
                }
            }

        }
        return res;
    }

}















