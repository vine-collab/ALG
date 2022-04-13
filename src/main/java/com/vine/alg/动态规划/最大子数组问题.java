package com.vine.alg.动态规划;

import java.util.Arrays;

/**
 * 输入一个数组，请找出其中一个和最大的子数组，返回这个子数组的和
 */

public class 最大子数组问题 {
    public static void main(String[] args) {
        try {
            最大子数组问题 z = new 最大子数组问题();
            int i = z.maxSubArray(new int[]{-3, 1, 3, -1, 2, -4, 2});
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
        dp[i] 表示：以nums[i] 结尾的最大子数组的和
     */
    int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            dp[i] = Integer.max(nums[i], nums[i] + dp[i - 1]);
        }


        return Arrays.stream(dp).max().getAsInt();
    }


}
