package com.vine.naive.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-04-24 10:00 PM
 */

public class 跳跃游戏_II {
    public static void main(String[] args) {
        跳跃游戏_II t = new 跳跃游戏_II();
        int dp = t.jump(new int[]{2, 1});
        System.out.println(dp);
    }


    /*
    给你一个非负整数数组nums ，你最初位于数组的第一个位置。

    数组中的每个元素代表你在该位置可以跳跃的最大长度。



    假设你总是可以到达数组的最后一个位置。


    示例 1:

    输入: nums = [2,3,1,1,4]
    输出: 2
    解释: 跳到最后一个位置的最小跳跃数是 2。
        从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
    示例 2:

    输入: nums = [2,3,0,1,4]
    输出: 2
     */
    public int jump(int[] nums) {

        return minJumpMemo(nums, 0, new HashMap<>());
    }


    /*
        pos表示当前的位置
     */
    int minJumpMemo(int[] nums, int pos, Map<Integer, Integer> memo) {
        int length = nums.length;
        // 到达末尾
        if (pos >= length - 1) {
            return 0;
        }
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int res = length + 1;
        int num = nums[pos];
        if (num == 0) {
            return res;
        }
        for (int i = 1; i <= num; i++) {
            // 跳了一次
            int times = minJumpMemo(nums, pos + i, memo) + 1;
            res = Integer.min(res, times);

        }
        memo.put(pos, res);
        return res;


    }

    /*
    dp[i] 表示第i个位置需要跳的最少步数
    dp[0] = 0

    dp[i] =

     */
    int dp(int[] nums) {

        int[] dp = new int[nums.length];


        return 0;
    }

}


















