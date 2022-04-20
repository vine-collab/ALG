package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-20 9:03 AM
 */

public class 目标和 {

    public static void main(String[] args) {
        目标和 m = new 目标和();
        int targetSumWays = m.findTargetSumWays(new int[]{1, 3, 1, 4, 2}, 5);
        System.out.println(targetSumWays);
    }


    int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, target, 0);
        return res;
    }


    int res = 0;


    void backtrack(int[] nums, int pos, int target, int val) {
        if (pos >= nums.length - 1) {
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


}
