package com.vine.alg.leetcode.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2021-05-21 10:46
 */

public class 分割等和子集 {


    boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        // dp[i][j] = x表示，对于前i个物品，当前背包的容量为j时，若x为true，则说明可以恰好将背包装满，若x为false，则说明不能恰好将背包装满。
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 不装、装
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }


        return dp[nums.length][sum];
    }


    public static void main(String[] args) {
        分割等和子集 c = new 分割等和子集();
        int[] nums = {1, 5, 11, 1};
        boolean b = c.canPartition(nums);
        System.out.println(b);
    }


}
