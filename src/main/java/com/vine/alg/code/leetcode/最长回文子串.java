package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-22 8:17 PM
 */

public class 最长回文子串 {


    boolean palindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            memo.put(s, false);
            return false;
        }
        memo.put(s, true);
        return true;

    }



    /*
    给你一个字符串 s，找到 s 中最长的回文子串。


    示例 1：

    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：

    输入：s = "cbbd"
    输出："bb"
     */

    Map<String, Boolean> memo = new HashMap<String, Boolean>();


    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                String substring = s.substring(j, i);

                boolean palindrome = palindrome(substring);
                if (palindrome) {
                    res = substring.length() > res.length() ? substring : res;
                }
            }
        }

        return res;
    }

    /*
        从中心扩散
     */
    String maxPalindrome(String s, int l, int r) {
        int n = s.length();

        while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);

    }

    String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = maxPalindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = maxPalindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static void main(String[] args) {
        最长回文子串 z = new 最长回文子串();
        String aba = z.longestPalindrome2("dbcd");
        System.out.println(aba);
    }


}
