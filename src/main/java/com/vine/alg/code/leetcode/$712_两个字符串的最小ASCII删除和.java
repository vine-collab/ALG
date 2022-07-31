package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-06-18 3:42 PM
 */

public class $712_两个字符串的最小ASCII删除和 {


    /**
     * https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/
     * <p>
     * 给定两个字符串s1和s2，返回 使两个字符串相等所需删除字符的ASCII值的最小和。
     * <p>
     *
     * <p>
     * 示例 1:
     * <p>
     * 输入: s1 = "sea", s2 = "eat"
     * 输出: 231
     * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
     * 在 "eat" 中删除 "t" 并将 116 加入总和。
     * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
     * 示例2:
     * <p>
     * 输入: s1 = "delete", s2 = "leet"
     * 输出: 403
     * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
     * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
     * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
     * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
     */
    public static void main(String[] args) {
        $712_两个字符串的最小ASCII删除和 l = new $712_两个字符串的最小ASCII删除和();
        int i = l.minimumDeleteSum("delete", "leet");
        System.out.println(i);
    }

    public int minimumDeleteSum(String s1, String s2) {
        return dp(s1, s2, 0, 0);
    }

    Map<String, Integer> memo = new HashMap<>();

    int dp(String s1, String s2, int i, int j) {
        int res = 0;
        if (i == s1.length()) {
            for (; j < s2.length(); j++) {
                res += s2.charAt(j);
            }
            return res;
        }

        if (j == s2.length()) {
            for (; i < s1.length(); i++) {
                res += s1.charAt(i);
            }
            return res;
        }
        String key = key(i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            memo.put(key, dp(s1, s2, i + 1, j + 1));
        } else {
            int min = Integer.min(dp(s1, s2, i, j + 1) + s2.charAt(j), dp(s1, s2, i + 1, j) + s1.charAt(i));
            memo.put(key, min);
        }
        return memo.get(key);

    }


    String key(int i, int j) {
        return i + "_" + j;
    }


}




















