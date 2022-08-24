package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-19 9:09 AM
 */

public class 打家劫舍1 {
    public static void main(String[] args) {
        try {
            打家劫舍1 d = new 打家劫舍1();
            int dp = d.rob(new int[]{2, 1, 7, 9, 3, 1});
            System.out.println(dp);
            int i = d.robDp(new int[]{2, 1, 7, 9, 3, 1});
            System.out.println(i);
        } catch (Exception e) {

        }
    }

    int rob(int[] nums) {
        return dp(nums, 0);
    }

    int dp(int[] nums, int pos) {
        if (pos >= nums.length) {
            return 0;
        }
        // 当前位置偷，不偷 的最大值
        int res = Integer.max(dp(nums, pos + 2) + nums[pos], dp(nums, pos + 1));
        return res;


    }

    /* dp[i] 表示从第i间房子开始偷，最多能偷的钱
        base case： dp[n] = 0;

     */
    int robDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.max(dp[i + 1], nums[i] + dp[i + 2]);

        }
        return dp[0];
    }


}
