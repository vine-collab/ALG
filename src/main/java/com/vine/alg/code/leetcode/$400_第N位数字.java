package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2023-09-17 5:11 PM
 */

public class $400_第N位数字 {


    public static void main(String[] args) {
        $400_第N位数字 z = new $400_第N位数字();
        int nthDigit = z.findNthDigit(12);
        System.out.println(nthDigit);
    }

    public int findNthDigit(int n) {
        // 位数（一位数，两位数...）
        int digit = 1;
        // 1,10,100, 1000 这样的后缀
        long base = 1;

        while (n > 9 * base * digit) {
            n -= 9 * base * digit;
            base *= 10;
            digit++;
        }

        // 此时假设 base = 1000，那么说明 n 是 100~999 中的某个三位数的某一位
        // 哪个三位数呢？这样算：
        long val = base + (n - 1) / digit;
        // 是这个三位数的第几位呢？这样算：
        int index = (n - 1) % digit;

        // 怎么把 val 的第 index 这一位数字抠出来呢？可以转化成字符串来算：
        return ("" + val).charAt(index) - '0';
    }

}
