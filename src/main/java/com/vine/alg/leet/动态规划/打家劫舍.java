package com.vine.alg.leet.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2021-05-28 17:23
 */

public class 打家劫舍 {


    /**************House Robber I start*****************/
    private Map<Integer, Integer> map = new HashMap<>();

    public int robI(int[] nums) {
        return funRob(nums, 0);
    }

    public int funRob(int[] nums, int start) {
        Integer integer = map.get(start);
        if (integer != null) {
            return integer;
        }
        if (start >= nums.length) {
            return 0;
        }

        int max = Math.max(funRob(nums, start + 1), funRob(nums, start + 2) + nums[start]);
        map.put(start, max);
        return max;

    }


    public int robDp(int[] nums) {
        // dp[i] 表示从第i间房子抢到最多的钱为dp[i], dp[nums.length] = 0;
        // 初始化数组长度为 nums.length+2，免于处理 i+2和i+1数组越界的问题
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            //               不抢，      抢
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

    public int robDpO1(int[] nums) {
        // dp[i] 表示从第i间房子抢到最多的钱为dp[i], dp[nums.length] = 0;
        int dpi1 = 0, dpi2 = 0;
        int dpi = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            //               不抢，      抢
            dpi = Math.max(dpi1, dpi2 + nums[i]);
            dpi2 = dpi1;
            dpi1 = dpi;
        }
        return dpi;
    }
    /**************House Robber I end*****************/


    /**************House Robber II start*****************/
    /*
    情况一：两头都不抢
    情况二：抢头不抢尾
    情况三：抢尾不抢头
    综合来看，二三肯定是优于一
    于是，在上述算法上取二三最大值即可
     */
    public int robII(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(dpII(nums, nums.length - 1, 1), dpII(nums, nums.length - 2, 0));
    }

    int dpII(int[] nums, int start, int end) {
        int dpi1 = 0, dpi2 = 0, dpi = 0;
        for (int i = start; i >= end; i--) {
            dpi = Math.max(dpi1, nums[i] + dpi2);
            dpi2 = dpi1;
            dpi1 = dpi;
        }


        return dpi;
    }

    /**************House Robber II end*****************/

    /**************House Robber III start*****************/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Map<TreeNode, Integer> memory = new HashMap<>();

    public int robIII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer memo = memory.get(root);
        if (memo != null) {
            return memo;
        }

        // 抢，然后去下下家
        int doRob = root.val;
        if (root.left != null) {
            doRob = doRob + robIII(root.left.left) + robIII(root.left.right);
        }
        if (root.right != null) {
            doRob = doRob + robIII(root.right.left) + robIII(root.right.right);
        }

        // 不抢，去下家
        int notRob = robIII(root.left) + robIII(root.right);
        int max = Math.max(doRob, notRob);
        memory.put(root, max);
        return max;
    }

    /**************House Robber III end*****************/

    public static void main(String[] args) {
        打家劫舍 c = new 打家劫舍();
        int rob = c.robI(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);
        System.out.println("-----------");
        System.out.println(c.robDp(new int[]{2, 7, 9, 3, 1}));
        System.out.println("-----------");
        System.out.println(c.robDpO1(new int[]{2, 7, 9, 3, 1}));
        System.out.println("-----------");
        System.out.println(c.robII(new int[]{1, 7}));

    }

}






















