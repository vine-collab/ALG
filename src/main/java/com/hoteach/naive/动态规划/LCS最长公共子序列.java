package com.hoteach.naive.动态规划;

/**
 * @author 阿季
 * @date 2021-05-18 20:38
 */

public class LCS最长公共子序列 {


    int longestCommonSequence(String s1, String s2, int start1, int start2) {
        for (int i = start1; i >= 0; i--) {
            for (int j = start2; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    return longestCommonSequence(s1, s2, i - 1, j - 1) + 1;
                } else {
                    return Math.max(longestCommonSequence(s1, s2, i - 1, j), longestCommonSequence(s1, s2, i, j - 1));
                }
            }
        }


        return 0;
    }


    public static void main(String[] args) {
        LCS最长公共子序列 c = new LCS最长公共子序列();
        String s1 = "abc";
        String s2 = "bxc";
        int start1 = s1.length() - 1;
        int start2 = s2.length() - 1;
        int i = c.longestCommonSequence(s1, s2, start1, start2);
        System.out.println(i);
    }

}
