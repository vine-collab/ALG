package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-08-13 4:31 PM
 */

public class $43_字符串相乘 {


    /**
     * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * <p>
     * <p>
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/multiply-strings
     */
    public static void main(String[] args) {
        $43_字符串相乘 z = new $43_字符串相乘();
        String multiply = z.multiply("123", "456");
        System.out.println(multiply);
    }


    public String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 计算乘积
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 结果高位在p1，低位在p2 位置对应的位置
                int p1 = i + j, p2 = p1 + 1;
                int sum = res[p2] + mul;
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        int i = 0;
        // 过滤前导0
        while (i < res.length && res[i] == 0) {
            i++;
        }
        StringBuilder str = new StringBuilder();

        for (; i < res.length; i++) {
            str.append(res[i]);
        }

        return str.length() == 0 ? "0" : str.toString();

    }
}































































