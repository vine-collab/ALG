package com.vine.alg.code.leetcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-18 4:46 PM
 */

public class $416_分割等和子集 {


    /**
     * 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：数组不能分割成两个元素和相等的子集。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/partition-equal-subset-sum
     */
    public static void main(String[] args) {
        $416_分割等和子集 f = new $416_分割等和子集();
        boolean b = f.canPartition2(new int[]{1, 2, 5});
        System.out.println(b);
    }


    /**
     *
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) {
            return false;
        }
        int n = nums.length;
        // 对于前i个物品，容量为sum/2 的背包，能装的最大价值为 dp[i][j]; 数组中的价值就是nums[i]
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j - nums[i - 1] >= 0) {
                    //                      装，                              不装
                    dp[i][j] = Integer.max(dp[i - 1][j - nums[i - 1]] + nums[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum / 2] == sum / 2;

    }

    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) {
            return false;
        }
        int n = nums.length;
        // 对于前i个物品，容量为sum/2 的背包，能装的最大价值为 dp[i][j]; 数组中的价值就是nums[i]
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j - nums[i - 1] >= 0) {
                    //                      装，                              不装
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum / 2];

    }


}
