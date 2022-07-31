package com.vine.alg.code.leetcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-26 4:26 PM
 */

public class $673_最长递增子序列的个数 {


    /**
     * 给定一个未排序的整数数组nums，返回最长递增子序列的个数。
     * <p>
     * 注意这个数列必须是 严格 递增的。
     * 示例 1:
     * <p>
     * 输入: [1,3,5,4,7]
     * 输出: 2
     * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
     * 示例 2:
     * <p>
     * 输入: [2,2,2,2,2]
     * 输出: 5
     * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/number-of-longest-increasing-subsequence
     */
    public static void main(String[] args) {
        $673_最长递增子序列的个数 z = new $673_最长递增子序列的个数();
        int numberOfLIS = z.findNumberOfLIS(new int[]{1,3,5,4,7});
        System.out.println(numberOfLIS);
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int ans = 0;
        // 表示num[i] 结尾的最长递增子序列长度为 dp[i];
        int[] dp = new int[n];
        // 表示 num[i] 结尾最长子序列的个数
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                if (dp[i] < dp[j] + 1) { // 第一次计算到dp[i] 和dp[j]
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (dp[i] == dp[j] + 1) {
                    cnt[i] = cnt[i] + cnt[j];
                }
            }
            if(dp[i] > maxLength) {
                maxLength = dp[i];
                ans = cnt[i];
            } else if(dp[i] == maxLength) {
                ans += cnt[i];
            }
        }

        return ans;
    }

}






















