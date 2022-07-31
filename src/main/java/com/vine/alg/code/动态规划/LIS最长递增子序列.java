package com.vine.alg.code.动态规划;

import java.util.Arrays;

/**
 *
 * @author 阿季
 * @date 2021-05-17 16:25
 */

public class LIS最长递增子序列 {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();


    }


    public static void main(String[] args) {
        LIS最长递增子序列 lis = new LIS最长递增子序列();
        int[] ints = {1, 6, 3, 5, 4, 4, 2};
        int i = lis.lengthOfLIS(ints);
        System.out.println(i);


    }


}
