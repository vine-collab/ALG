package com.vine.alg.code.leetcode;


/**
 * @author 阿季
 * @date 2022-05-02 6:05 PM
 */

public class $8_字符串转换整数 {
    public static void main(String[] args) {
        $8_字符串转换整数 z = new $8_字符串转换整数();
        int i = z.myAtoi("   -91283472332   ");
        System.out.println(i);

    }

    /**
     * https://leetcode.cn/problems/string-to-integer-atoi/submissions/
     * @param s
     * @return
     */

    public int myAtoi(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }

        s = s.trim();

        if(s.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int i = 0;
        if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(s.charAt(i) == '+') {
            i++;
        }
        if(i == s.length()) {
            return 0;
        }

        long res = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            res = res * 10 + s.charAt(i) - '0';
            if(res * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)res * sign;


    }
}
