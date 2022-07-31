package com.vine.alg.code.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2022-06-17 8:25 PM
 */

public class $119_最长连续序列 {

    public static void main(String[] args) {
        $119_最长连续序列 z = new $119_最长连续序列();
        int i = z.longestConsecutive(new int[]{0, 1, 1, 2});
        System.out.println(i);
    }

    /**
     * https://leetcode.cn/problems/WhsWhI/
     * <p>
     * 剑指 Offer II 119. 最长连续序列
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * <p>
     * dp[i] 表示以nums[i] 结尾的最长连读子序列长度为 dp[i]
     * base case dp[i] = 1
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                dp[i] = Integer.max(dp[i - 1] + 1, dp[i]);
            }
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            }
        }


        return Arrays.stream(dp).max().getAsInt();
    }


    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


}














