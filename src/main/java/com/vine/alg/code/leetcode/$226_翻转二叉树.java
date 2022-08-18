package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-06 8:23 PM
 */

public class $226_翻转二叉树 {


    /**
     * https://leetcode.cn/problems/invert-binary-tree/
     */
    public static void main(String[] args) {
        $226_翻转二叉树 f = new $226_翻转二叉树();
    }

    // 子问题：返回root的反转树

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);


        root.left = right;
        root.right = left;
        return root;


    }


    public TreeNode invertTree1(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        traverse(root.left);
        traverse(root.right);

    }


}
