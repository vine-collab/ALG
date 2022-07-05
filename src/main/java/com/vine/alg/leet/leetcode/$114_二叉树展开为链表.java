package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-05 11:18 PM
 */

public class $114_二叉树展开为链表 {

    /**
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
     */
    public static void main(String[] args) {
        $114_二叉树展开为链表 z = new $114_二叉树展开为链表();

    }

    // 用后序遍历
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode tempRight = root.right;

        root.right = root.left;
        root.left = null;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = tempRight;

    }

}
