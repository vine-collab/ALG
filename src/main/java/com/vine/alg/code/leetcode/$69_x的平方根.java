package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-07-30 4:24 PM
 */

public class $69_x的平方根 {

    public static void main(String[] args) {
        $69_x的平方根 x = new $69_x的平方根();
        int i = x.mySqrt(8);
        System.out.println(i);
    }


    public int mySqrt(int x) {

        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(mid * mid == x) {
                return mid;
            } else if(mid * mid < x) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }

        }
        return ans;



    }



}































































