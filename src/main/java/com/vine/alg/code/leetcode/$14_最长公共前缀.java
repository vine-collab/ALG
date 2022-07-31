package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-06-29 7:54 PM
 */

public class $14_最长公共前缀 {


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串""。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/longest-common-prefix
     */
    public static void main(String[] args) {
        $14_最长公共前缀 z = new $14_最长公共前缀();
        String s = z.longestCommonPrefix(new String[]{"x", "flow", "flight"});
        System.out.println(s);

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


}
