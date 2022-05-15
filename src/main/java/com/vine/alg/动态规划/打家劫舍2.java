package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-19 9:09 AM
 */

public class 打家劫舍2 {
    public static void main(String[] args) {
        try {
            打家劫舍2 d = new 打家劫舍2();
            int dp = d.rob(new int[]{1, 2, 3, 1});
            System.out.println(dp);
            int i = d.robDp(new int[]{2,3,2});
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
        两头都不抢
        抢头不抢尾
        抢尾不抢头
        取最大值
     */

    int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }


        return Integer.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));
    }

    int dp(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        // 当前位置偷，不偷 的最大值
        int res = Integer.max(dp(nums, start + 2, end) + nums[start], dp(nums, start + 1, end));
        return res;


    }


    int robDp(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }


        return Integer.max(robDp(nums, 0, n - 2), robDp(nums, 1, n - 1));
    }


    /* dp[i] 表示从第i间房子开始偷，最多能偷的钱
        base case： dp[n] = 0;

     */
    int robDp(int[] nums, int start, int end) {
        int dp = 0, dp_pre = 0, dp_pre_pre = 0;
        for (int i = end; i >= start; i--) {
            dp = Integer.max(dp_pre, nums[i] + dp_pre_pre);
            dp_pre_pre = dp_pre;
            dp_pre = dp;

        }
        return dp;
    }


}
