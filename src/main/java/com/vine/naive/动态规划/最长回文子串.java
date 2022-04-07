package com.vine.naive.动态规划;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * @author 阿季
 * @date 2021-05-22 17:29
 */

public class 最长回文子串 {

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }


        return "";

    }

    /**
     * 表示字符串s，前pos个字符的最长回文子串
     *
     * @param s
     * @param pos
     * @return
     */
    public String dp(String s) {

        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                boolean test = test(temp);
                if (test) {
                    result = temp.length() > result.length() ? temp : result;
                }
            }
        }

        return result;
    }


    public boolean test(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        最长回文子串 c = new 最长回文子串();
        String abdc = c.longestPalindrome("abdc");
        System.out.println(abdc);

        boolean abc = c.test("bfbfb");
        System.out.println(abc);
        String bfbfb = c.dp("bfbfb");
        System.out.println(bfbfb);
    }

}







