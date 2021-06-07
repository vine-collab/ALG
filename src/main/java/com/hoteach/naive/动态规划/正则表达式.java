package com.hoteach.naive.动态规划;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * <p>
 *
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
        boolean first = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
            return dp(s, p, i, j + 2) || (first && dp(s, p, i + 1, j));
        } else {
            return first && dp(s, p, i + 1, j + 1);
        }
    }


    public boolean isMatchTest(String s, String p) {

        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean first = (s != null && s.length() != 0) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean match = isMatchTest(s, p.substring(2))
                    || (first
                    && isMatchTest(s.substring(1), p));
            return match;
        } else {
            return first && isMatchTest(s.substring(1), p.substring(1));
        }


    }


    public static void main(String[] args) {
        正则表达式 c = new 正则表达式();
        System.out.println(c.isMatch("aab", "c*a*b"));
        System.out.println("------------------");
        System.out.println(c.isMatchTest("aab", "c*a*b"));
    }

}
