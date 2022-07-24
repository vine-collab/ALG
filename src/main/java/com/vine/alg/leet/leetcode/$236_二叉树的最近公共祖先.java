package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-16 5:14 PM
 */

public class $236_二叉树的最近公共祖先 {


    /**
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
     */
    public static void main(String[] args) {
        $236_二叉树的最近公共祖先 e = new $236_二叉树的最近公共祖先();
    }

    /*
        给定输入参数root p q 返回一个节点
        1、如果pq都在以root为根的树中，返回 pq的最近公共祖先节点
        2、如果pq都不在以root为根的树中，返回null；
        3、如果pq只有一个在root为根的树中，返回那个节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况1 如果p和q都在以root为根的树中，那么left和right一定分别是p和q（从 base case 看出来的）。
        if (left != null && right != null) {
            return root;
        }
        // 情况2 如果p和q都不在以root为根的树中，直接返回null。
        if (left == null && right == null) {
            return null;
        }
        // 情况3  如果p和q只有一个存在于root为根的树中，函数返回该节点。
        return left == null ? right : left;

    }

}































































