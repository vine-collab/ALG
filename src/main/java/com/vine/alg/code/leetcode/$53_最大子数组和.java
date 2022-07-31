package com.vine.alg.code.leetcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-16 8:42 PM
 */

public class $53_最大子数组和 {


    public static void main(String[] args) {
        $53_最大子数组和 z = new $53_最大子数组和();
        int i = z.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    /**
     * https://leetcode.cn/problems/maximum-subarray/
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 以num[i] 结尾的 最大子数组和为 dp[i]
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.max(nums[i], dp[i - 1] + nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();



    }


}
