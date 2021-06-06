package com.hoteach.naive.动态规划;

/**
 * @author 阿季
 * @date 2021-06-06 17:47
 */

public class 正则表达式 {

    public boolean isMatch(String s, String p) {
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        boolean result;
        boolean first = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?');
        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
            result = dp(s, p, i, j + 2) || (first && dp(s, p, i + 1, j));
        } else {
            result = first && dp(s, p, i + 1, j + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        正则表达式 c = new 正则表达式();
        boolean match = c.isMatch("aa", "*");
        System.out.println(match);
    }

}
