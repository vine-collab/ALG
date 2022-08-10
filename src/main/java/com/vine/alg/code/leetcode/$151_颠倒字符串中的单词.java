package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-08-10 9:13 PM
 */

public class $151_颠倒字符串中的单词 {


    /**
     * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
     * <p>
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * <p>
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * <p>
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，
     * 单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     * <p>
     * 输入：s = " hello world "
     * 输出："world hello"
     * 解释：颠倒后的字符串中不能存在前导空格和尾随空格。
     * 示例 3：
     * <p>
     * 输入：s = "a good  example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
     */
    public static void main(String[] args) {
        $151_颠倒字符串中的单词 d = new $151_颠倒字符串中的单词();
        String the_sky_is_blue = d.reverseWords("a good   example");
        System.out.println(the_sky_is_blue);
    }


    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();

        String flip = flip(s);
        String[] split = flip.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].isEmpty()) {
                continue;
            }
            String part = flip(split[i]);
            res.append(part);
            if (i < split.length - 1) {
                res.append(" ");
            }
        }


        return res.toString();
    }


    String flip(String s) {
        s = s.trim();
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}































































