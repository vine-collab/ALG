package com.vine.alg.code.leetcode;


/**
 * @author 阿季
 * @date 2022-05-02 3:43 PM
 */

public class $10_正则表达式匹配 {

    /*
    10. 正则表达式匹配
    给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

    示例 1：

    输入：s = "aa", p = "a"
    输出：false
    解释："a" 无法匹配 "aa" 整个字符串。
    示例 2:

    输入：s = "aa", p = "a*"
    输出：true
    解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
    示例 3：

    输入：s = "ab", p = ".*"
    输出：true
    解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     */
    public static void main(String[] args) {
        $10_正则表达式匹配 z = new $10_正则表达式匹配();
        boolean match = z.isMatch("ab", ".*");
        System.out.println(match);
    }

    public boolean isMatch(String s, String p) {

        return dp(s, p, 0, 0);
    }


    /*
       dp = true 表示 s[i...] 可以匹配 [j...]
       结果在dp(s, p, 0, 0)
       base case
       s 到达尽头，i = s.length
            判断 p[j...] 是否能匹配空串 即 x*y*z* 格式 成对出现
     */
    boolean dp(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (i == s.length()) {
            // 如果能匹配空串，一定是字符和 * 成对儿出现
            if ((p.length() - j) % 2 != 0) {
                return false;
            }
            // 检查是否为 x*y*z* 这种形式
            while (j + 1 < p.length()) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
                j += 2;
            }
            return true;

        }

        // i和j匹配
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                //                 // // 有 * 通配符,匹配0 次， 或者多次j + 2) // 匹配0次，p指针 +2，s指正不变
                return dp(s, p, i, j + 2) // 匹配0次，p指针 +2，s指正不变
                        || dp(s, p, i + 1, j); // 匹配多次，p指针不变，s指针+1
            } else {
                // 无 * 通配符，老老实实匹配 1 次
                return dp(s, p, i + 1, j + 1);
            }
        }
        // i和j匹配不上
        else {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // 通配符匹配0次
                return dp(s, p, i, j + 2); // 匹配0次，p指针 +2，s指正不变
            } else {
                // 无 * 通配符，无法匹配
                return false;
            }

        }

    }


}


















