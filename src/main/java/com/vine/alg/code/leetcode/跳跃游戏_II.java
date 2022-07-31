package com.vine.alg.code.leetcode;

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
        int i = t.jump1(new int[]{2, 1});
        System.out.println(i);
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
        表示从pos跳到最后最少要 minJumpMemo步
        结果就是minJumpMemo(nums, 0)

     */
    int minJumpMemo(int[] nums, int pos, Map<Integer, Integer> memo) {
        int length = nums.length;
        // base case到达末尾
        if (pos >= length - 1) {
            return 0;
        }
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int num = nums[pos];
        int step = num;
        if (num == 0) {
            return step;
        }
        for (int i = 1; i <= num; i++) {
            // 跳了一次
            int times = minJumpMemo(nums, pos + i, memo) + 1;
            step = Integer.min(step, times);

        }
        memo.put(pos, step);
        return step;


    }

    /*
    dp[i] 表示第i个位置需要跳的最少步数
    dp[0] = 0

    dp[i] =

     */
    int jump1(int[] nums) {

        int length = nums.length;
        // 从[i...end]起跳，能跳的最远距离
        int end = 0;

        int farthest = 0;

        // 记录跳的次数
        int jumps= 0;
        for (int i = 0; i < length - 1; i++) {
            farthest = Integer.max(farthest, i + nums[i]);
            if(end == i) {
                jumps ++;
                end = farthest;
            }
        }

        return jumps;
    }

}


















