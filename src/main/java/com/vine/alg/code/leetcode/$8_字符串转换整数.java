package com.vine.alg.code.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2022-05-02 6:05 PM
 */

public class $8_字符串转换整数 {
    public static void main(String[] args) {
        $8_字符串转换整数 z = new $8_字符串转换整数();
        int i = z.myAtoi(" ");
        System.out.println(i);

    }


    public int myAtoi(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        }
        String trim = s.trim();
        Character[] digital = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Set<Character> collect = Arrays.stream(digital).collect(Collectors.toSet());


        long res = 0;
        long symbol = 1;


        if (trim.charAt(0) == '-') {
            symbol *= -1;
        } else if (trim.charAt(0) == '+') {

        } else if (collect.contains(trim.charAt(0))) {
            res += Character.getNumericValue(trim.charAt(0));
        } else {
            return 0;
        }


        for (int i = 1; i < trim.length(); i++) {

            int numericValue = Character.getNumericValue(trim.charAt(i));
            if (numericValue < 10 && collect.contains(trim.charAt(i))) {
                long temp;
                if (res == 0) {
                    temp = res + numericValue;
                } else {
                    temp = res * 10 + numericValue;
                }
                if (symbol * temp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                if (symbol * temp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                res = (int) temp;
            } else {
                break;
            }
        }


        return (int) ((int) res * symbol);
    }
}
