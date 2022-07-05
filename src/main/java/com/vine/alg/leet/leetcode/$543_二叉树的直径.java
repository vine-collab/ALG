package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-05 9:51 PM
 */

public class $543_二叉树的直径 {

    /**
     * https://leetcode.cn/problems/diameter-of-binary-tree/
     */
    public static void main(String[] args) {
        $543_二叉树的直径 e = new $543_二叉树的直径();
    }

    //求深度和最大值 递归解法，分解问题
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;

    }

    int res = 0;

    // 求树的最大深度
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        res = Integer.max(left + right, res);
        return Integer.max(left, right) + 1;
    }


    // 记录最大直径的长度
    int maxDiameter = 0;

    public int diameterOfBinaryTree1(TreeNode root) {
        // 对每个节点计算直径，求最大直径
        traverse(root);
        return maxDiameter;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 对每个节点计算直径
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax;
        // 更新全局最大直径
        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }


}
