package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-08-11 8:43 PM
 */

public class $110_平衡二叉树 {

    public static void main(String[] args) {
        $110_平衡二叉树 p = new $110_平衡二叉树();
    }


    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    boolean isBalanced = true;

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }


        return Math.max(left, right) + 1;
    }


}






























































