package com.vine.alg.code.topcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.lang.invoke.MutableCallSite;

/**
 * @author 阿季
 * @date 2022-09-05 10:01 PM
 */

public class $209_长度最小的子数组 {


    /**
     * https://leetcode.cn/problems/minimum-size-subarray-sum/
     */
    public static void main(String[] args) {
        $209_长度最小的子数组 c = new $209_长度最小的子数组();
        int[] ints = Utils.splitToIntArr1("2,3,1,2,4,3");
        int i = c.minSubArrayLen(7, ints);
        System.out.println(i);
    }


    public int minSubArrayLen(int target, int[] nums) {

        int left = 0, right = 0;
        int len = nums.length + 1;
        int sum = 0;
        while (right < nums.length) {
            int num = nums[right];
            right++;
            sum += num;

            while (sum >= target) {
                len = Integer.min(len, right - left);
                sum -= nums[left];
                left++;

            }
        }

        return len;


    }


}































































