package com.vine.alg.leet.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-06-25 3:49 PM
 */

public class $45_跳跃游戏II {


    /**
     * https://leetcode.cn/problems/jump-game-ii/
     * 45. 跳跃游戏 II
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * <p>
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     */
    public static void main(String[] args) {
        $45_跳跃游戏II t = new $45_跳跃游戏II();
        int jump = t.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);


        int jump1 = t.jump1(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump1);
    }

    public int jump(int[] nums) {
        int dp = dp(nums, 0);
        return dp;
    }


    Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 从第i个位置跳到最后一个位置的 最少次数为 dp
     * base case
     * i = nums.length - 1 -> 0
     * <p>
     * dp[i] = dp[i + 1]
     */
    int dp(int[] nums, int pos) {
        if (pos >= nums.length - 1) {
            return 0;
        }
        Integer m = memo.get(pos);
        if (m != null) {
            return m;
        }
        // 在pos位置可以跳的距离
        int res = Integer.MAX_VALUE;
        int step = nums[pos];
        for (int i = 1; i <= step; i++) {
            int dp = dp(nums, pos + i);
            res = Integer.min(res, dp + 1);
        }

        memo.put(pos, res);
        return res;

    }


    int jump1(int[] nums) {

        int steps = 0, n = nums.length, farthest = 0, end = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Integer.max(farthest, nums[i] + i);
            if (i == end) {
                steps++;
                end = farthest;
            }
        }
        return steps;


    }


}


























