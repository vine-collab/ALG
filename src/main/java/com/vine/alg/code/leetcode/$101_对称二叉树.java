package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.time.temporal.ChronoField;

/**
 * @author 阿季
 * @date 2022-07-31 4:16 PM
 */

public class $101_对称二叉树 {


    /**
     * https://leetcode.cn/problems/symmetric-tree/
     */
    public static void main(String[] args) {
        $101_对称二叉树 d = new $101_对称二叉树();
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 检查两颗子树是否对称
        return check(root.left, root.right);

    }


    boolean check(TreeNode left, TreeNode right) {

        if (left == null || right == null) {
            return left == right;
        }

        // 根节点
        if (left.val != right.val) {
            return false;
        }

        // 左右子节点需要对称相同
        return check(left.right, right.left) && check(left.left, right.right);

    }
}



























































