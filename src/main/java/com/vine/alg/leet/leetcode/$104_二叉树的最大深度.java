package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-05 9:22 PM
 */

public class $104_二叉树的最大深度 {


    /**
     * https://leetcode.cn/problems/maximum-depth-of-binary-tree/submissions/
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Integer.max(left, right) + 1;
    }


    public int maxDepth1(TreeNode root) {
        traverse(root);
        return res;
    }

    int res = 0;
    int depth = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        res = Integer.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;

    }


}
