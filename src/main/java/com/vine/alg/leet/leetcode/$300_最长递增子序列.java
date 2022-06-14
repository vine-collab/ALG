package com.vine.alg.leet.leetcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-13 10:03 PM
 */

public class $300_最长递增子序列 {
    public static void main(String[] args) {
        $300_最长递增子序列 z = new $300_最长递增子序列();
        int i = z.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }

    /**
     * https://leetcode.cn/problems/longest-increasing-subsequence/
     * 300. 最长递增子序列
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;



    }

}
