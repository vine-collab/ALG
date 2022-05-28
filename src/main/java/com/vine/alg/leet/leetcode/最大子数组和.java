package com.vine.alg.leet.leetcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-04-23 6:02 PM
 */

public class 最大子数组和 {

    public static void main(String[] args) {
        最大子数组和 z = new 最大子数组和();
        int i = z.maxSubArray(new int[]{5,4,-1,7,8});
        System.out.println(i);
    }

    /*
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    子数组 是数组中的一个连续部分。


    示例 1：

    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    示例 2：

    输入：nums = [1]
    输出：1
    示例 3：

    输入：nums = [5,4,-1,7,8]
    输出：23


    dp[i] 表示：以nums[i] 结尾的和为dp[i]


     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(nums[i], dp[i - 1] + nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}


















