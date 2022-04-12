package com.vine.alg.动态规划;

import java.util.Arrays;

/**
 *
 */

public class 最长递增子序列 {

    public static void main(String[] args) {
        try {
            最长递增子序列 z = new 最长递增子序列();
            int i = z.longOfLIS(new int[]{1, 4, 3, 4});
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        定义：dp[i] 表示以 num[i] 结尾的最长递增子序列的长度
        ** 注意：这是解决子序列的一个套路定义。
     */
    int longOfLIS(int[] nums) {


        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }


        return Arrays.stream(dp).max().getAsInt();

    }

}














