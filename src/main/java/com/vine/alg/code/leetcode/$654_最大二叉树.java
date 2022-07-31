package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-07 9:09 PM
 */

public class $654_最大二叉树 {

    /**
     * https://leetcode.cn/problems/maximum-binary-tree/
     */
    public static void main(String[] args) {
        $654_最大二叉树 z = new $654_最大二叉树();
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return bulid(nums, 0, nums.length - 1);

    }

    TreeNode bulid(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = l; i <= r; i++) {
            if(max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = bulid(nums, l, index - 1);
        root.right = bulid(nums, index + 1, r);
        return root;

    }

}
