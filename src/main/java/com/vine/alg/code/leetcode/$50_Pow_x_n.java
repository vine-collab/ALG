package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2023-10-22 3:41 PM
 */

public class $50_Pow_x_n {


    /**
     * https://leetcode.cn/problems/powx-n/description/
     */
    public static void main(String[] args) {
        $50_Pow_x_n z = new $50_Pow_x_n();

    }

    public double myPow(double a, int n) {
        if(n == 0) {
            return 1;
        }

        if(n == Integer.MIN_VALUE) {
            return myPow(1 / a, -(n + 1)) / a;
        }

        if(n < 0) {
            return myPow(1 / a, -n);
        }

        if(n % 2 == 1) {
            return (a * myPow(a, n - 1));
        } else {
            double sub = myPow(a, n / 2);
            return sub * sub;
        }

    }

}
