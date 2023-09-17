package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2023-09-17 11:22 AM
 */

public class $647_回文子串 {


    public static void main(String[] args) {
        $647_回文子串 z = new $647_回文子串();
        int abc = z.countSubstrings1("aaaaa");
        System.out.println(abc);
    }


    public int countSubstrings(String s) {
        int res = 0;
        this.s = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            res += count(i, i);
            res += count(i, i + 1);
        }
        return res;
    }

    char[] s;

    int count(int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--;
            r++;
            res++;
        }
        return res;
    }


    public int countSubstrings1(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n]; //表示dp[i][j] 为回文子串

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) { // aa,aba 的情况
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    res++;
                }
            }
        }

        return res;


    }


}
