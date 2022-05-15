package com.vine.alg.leetcode.leetcode;

/**
 * @author 阿季
 * @date 2022-05-15 5:48 PM
 */

public class $213_打家劫舍II {

    /**
     * https://leetcode.cn/problems/house-robber-ii/
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * <p>
     * 示例 1：
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * <p>
     * 示例 2：
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * <p>
     * 示例 3：
     * 输入：nums = [1,2,3]
     * 输出：3
     */
    public static void main(String[] args) {
        $213_打家劫舍II d = new $213_打家劫舍II();
        int rob = d.rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }


    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        // 偷第一个房间
        int rob = robDp(nums, 0, n - 2);
        // 偷最后一个房间
        int rob1 = robDp(nums, 1, n - 1);
        return Integer.max(rob, rob1);
    }

    int robDp(int[] nums, int start, int end) {
        int dp = 0, dp_pre = 0, dp_pre_pre = 0;
        for (int i = end; i >= start; i--) {
            dp = Integer.max(dp_pre, nums[i] + dp_pre_pre);
            dp_pre_pre = dp_pre;
            dp_pre = dp;

        }
        return dp;
    }

    /*
        dp[i] 表示 从第i个房间开始能偷到的钱

        结果在dp[0]

        当前房间偷 dp[i] = num[i] + dp[i + 2]
        当前房间不偷 dp [i] = dp[i + 1]

     */
    public int dp(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        // 当前位置偷
        int rob = dp(nums, start + 2, end) + nums[start];
        // 当前位置不偷，偷下一个位置
        int rob1 = dp(nums, start + 1, end);
        return Integer.max(rob, rob1);


    }


}



















