package com.vine.alg.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-16 4:05 PM
 */

public class 正则表达式 {

    public static void main(String[] args) {
        try {
            正则表达式 z = new 正则表达式();
            boolean i = z.isMatch("ab", ".*");
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Map<String, Boolean> memo = new HashMap<>();

    boolean isMatch(String s, String p) {
        return dp(s, p, 0, 0);

    }

    /*
        dp(s, p, i, j) == true 表示 s[i...], p[j...] 能通配
        则 dp[0][0] 就是需要的结果
        base case
        j = p.length
        或者
        i = s.length && p[j...] 能匹配空串，x*成对出现

     */
    boolean dp(String s, String p, int i, int j) {
        int slength = s.length();
        int plength = p.length();

        //  表达式到头了
        if (j == plength) {
            return i == slength;
        }

        // s到头了
        if (i == slength) {
            // p剩下奇数个无法成对出现
            if ((plength - j) % 2 == 1) {
                return false;
            }
            // 判断后续字符串是否是 x*成对出现
            for (; j + 1 < plength; j = j + 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;

        }

        if (memo.containsKey(i + "_" + j)) {
            return memo.get(i + "_" + j);
        }


        boolean res;
        // 匹配上了
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < plength - 1 && p.charAt(j + 1) == '*') {

                res =  dp(s, p, i, j + 2) // 匹配0次，p指针 +2，s指正不变
                        || dp(s, p, i + 1, j); // 匹配多次，p指针不变，s指针+1
            } else {
                // 后移
                res = dp(s, p, i + 1, j + 1);
            }
        } else {
            // 未匹配上
            if (j < plength - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, p, i, j + 2); // * 让前面字符不重复

            } else {
                // 无法匹配了
                res = false;
            }
        }

        memo.put(i + "_" + j, res);

        return res;
    }


}
















