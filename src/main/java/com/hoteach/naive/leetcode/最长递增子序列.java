package com.hoteach.naive.leetcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2021-06-08 15:38
 */

public class 最长递增子序列 {


    public int lengthOfLIS(int[] nums) {
        // 以nums[i]结尾的最长递增子序列长度为dp[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        最长递增子序列 c = new 最长递增子序列();
        int i = c.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        System.out.println(i);
    }

}
