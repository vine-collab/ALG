package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2023-04-03 10:11 PM
 */

public class $1312_让字符串成为回文串的最少插入次数 {


    /**
     * 给你一个字符串s，每一次操作你都可以在字符串的任意位置插入任意字符。
     * <p>
     * 请你返回让s成为回文串的最少操作次数。
     * <p>
     * 「回文串」是正读和反读都相同的字符串。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "zzazz"
     * 输出：0
     * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
     * 示例 2：
     * <p>
     * 输入：s = "mbadm"
     * 输出：2
     * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
     * 示例 3：
     * <p>
     * 输入：s = "leetcode"
     * 输出：5
     * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
     * <p>
     * 链接：https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome
     */
    public static void main(String[] args) {
        $1312_让字符串成为回文串的最少插入次数 z = new $1312_让字符串成为回文串的最少插入次数();
        int leetcode = z.minInsertions("leetcode");
        System.out.println(leetcode);
    }


    public int minInsertions(String s) {
        if (s == null || s.length() == 1) {
            return 0;
        }
        int l = s.length();
        int[][] dp = new int[l + 1][l + 1];
        for (int i = 0; i <= l; i++) {
            dp[i][i] = 0;
        }

        for (int i = l - 1; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][l - 1];
    }


}































































