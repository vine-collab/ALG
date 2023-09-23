package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2023-09-23 2:31 PM
 */

public class $28_找出字符串中第一个匹配项的下标 {


    public static void main(String[] args) {
        $28_找出字符串中第一个匹配项的下标 z = new $28_找出字符串中第一个匹配项的下标();
        int i = z.strStr("sadbutsad", "sad");
        System.out.println(i);
    }

    /**
     * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     * <p>
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;

    }

}
