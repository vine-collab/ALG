package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-06-22 8:30 PM
 */

public class $5_最长回文子串 {
    public static void main(String[] args) {
        $5_最长回文子串 z = new $5_最长回文子串();
        String babad = z.longestPalindrome("bddb");
        System.out.println(babad);
        String babad1 = z.longestPalindrome2("bddb");
        System.out.println(babad1);
    }


    /**
     * dp：ij开头和结尾的是回文
     * base case
     * 1、单个字符，对角线为true
     * <p>
     * 递推重点(0, n - 1)
     */
    public String longestPalindrome(String s) {

        int n = s.length(), start = 0, len = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) { // 两个字符，或者两个字符中间夹一个字符如"aba"
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (!dp[i][j]) {
                    continue;
                }
                if (j - i + 1 > len) {
                    len = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + len);
    }

    public String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = longest(s, i, i);
            String s2 = longest(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;


    }

    String longest(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }


}
