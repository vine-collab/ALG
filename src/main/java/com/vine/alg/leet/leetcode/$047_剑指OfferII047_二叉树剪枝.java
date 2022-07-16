package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-16 6:51 PM
 */

public class $047_剑指OfferII047_二叉树剪枝 {

    /**
     * https://leetcode.cn/problems/pOCWxh/
     */

    public static void main(String[] args) {

    }


    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;


    }


}































































