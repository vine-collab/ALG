package com.vine.alg.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-04-20 9:03 AM
 */

public class 目标和 {

    public static void main(String[] args) {
        目标和 m = new 目标和();
        int targetSumWays = m.findTargetSumWays(new int[]{1, 3, 1, 4, 2}, 5);
        System.out.println(targetSumWays);
        int 背包解法 = m.背包解法(new int[]{1, 3, 1, 4, 2}, 5);
        System.out.println(背包解法);
    }


    int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, target, 0);
        return res;
    }


    int res = 0;


    void backtrack(int[] nums, int pos, int target, int val) {

        if (pos == nums.length) {
            if (target == val) {
                res++;
            }
            return;
        }

        // 做选择，要么取正，要么取反
        int num = nums[pos];

        // 取正数
        val = val - num;
        backtrack(nums, pos + 1, target, val);
        val = val + num;

        // 取负数
        val = val + num;
        backtrack(nums, pos + 1, target, val);
        val = val - num;


    }

    int dp(int[] nums) {

        return 0;
    }


    /*
        题目转换：将nums划分成两个子集A、B分别代表 + 和 - 的数，那么和target 关系推导
        sum(A) + sum(B) = target -> sum(A) = target - sum(B)
        -> 2sum(A) = sum(A) - sum(B) + target -> 2sum(A) = sum(nums) + target
        -> sum(A) = [sum(nums) + target] / 2
        -> 在nums中存在几个子集A, 使得A中元素的和为[sum(nums) + target] / 2

        定义：dp[i][j]：表示前i个物品，背包的容量为j时，最多的装法为dp[i][j]
        base case
        dp[0][j] = 0
        dp[i][0] = 1


     */
    int 背包解法(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || (sum + target) % 2 != 0) {
            return 0;
        }

        int n = nums.length;
        int capacity = (sum + target) / 2;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                // 容量是否还够
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }


}



















