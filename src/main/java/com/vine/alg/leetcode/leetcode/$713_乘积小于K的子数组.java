package com.vine.alg.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-16 9:27 PM
 */

public class $713_乘积小于K的子数组 {


    /**
     * https://leetcode.cn/problems/subarray-product-less-than-k/
     * 713. 乘积小于 K 的子数组
     * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
     * <p>
     * 示例 1：
     * 输入：nums = [10,5,2,6], k = 100
     * 输出：8
     * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
     * <p>
     * 示例 2：
     * 输入：nums = [1,2,3], k = 0
     * 输出：0
     */
    public static void main(String[] args) {
        $713_乘积小于K的子数组 c = new $713_乘积小于K的子数组();
        int i = c.numSubarrayProductLessThanK2(new int[]{1,2,3}, 0);
        System.out.println(i);
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int product = product(nums, i, j);
                if (product < k) {
                    res++;
                }
            }
        }

        return res;
    }

    public int product(int[] num, int start, int end) {
        Long res = 1L;
        for (int i = start; i <= end; i++) {
            res *= num[i];
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }


        return res.intValue();
    }


    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }
        int res = 0;
        int left = 0, right = 0;
        int multiply = 1;
        while (right < nums.length) {
            int num = nums[right];
            multiply *= num;

            // 不满足条件移除窗口
            while (multiply >= k) {
                multiply /= nums[left];
                left++;
            }

            res += right - left + 1;
            // 窗口右移
            right++;
        }

        return res;
    }

}















