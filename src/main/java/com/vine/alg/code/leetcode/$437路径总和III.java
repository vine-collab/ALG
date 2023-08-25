package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2023-08-19 21:38
 */

public class $437路径总和III {

    public static void main(String[] args) {
        $437路径总和III z = new $437路径总和III();
    }


    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * https://leetcode.cn/problems/path-sum-iii/description/
     */

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }
        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;

    }

    int rootSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }


    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }


    int rootSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if(targetSum - root.val == 0) {
            res++;
        }

        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;

    }


}































































