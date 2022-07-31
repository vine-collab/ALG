package com.vine.alg.code.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2021-05-17 20:23
 */

public class 最大子数组和 {


    public int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        // 以nums[i]为结尾的「最大子数组和」为dp[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }


    public int maxSubArray2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        // 以nums[i]为结尾的「最大子数组和」为dp[i]
        int result = 0;
        int dp_pre = nums[0];
        int dp_curr = 0;
        for (int i = 1; i < nums.length; i++) {
            // dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            dp_curr = Math.max(nums[i], dp_pre + nums[i]);
            dp_pre = dp_curr;
            result = Math.max(result, dp_pre);


        }

        return result;
    }


    public static void main(String[] args) {
        最大子数组和 c = new 最大子数组和();
        int[] i = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i1 = c.maxSubArray(i);
        int i2 = c.maxSubArray2(i);
        System.out.println(i1);
        System.out.println(i2);
    }
}
