package com.hoteach.naive.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author 阿季
 * @date 2021-06-02 17:41
 */

public class 最大子序和 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 以nums[i]结尾的连续子串和最大值为dp[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + dp[i - 1];
            if (sum < nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }


    public static void main(String[] args) {
        最大子序和 c = new 最大子序和();
        int i = c.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

}
