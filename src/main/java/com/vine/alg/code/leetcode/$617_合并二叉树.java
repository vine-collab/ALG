package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-06-03 4:56 PM
 */

public class $617_合并二叉树 {


    /**
     * https://leetcode.cn/problems/merge-two-binary-trees/
     */
    public static void main(String[] args) {
        $617_合并二叉树 h = new $617_合并二叉树();


    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }


        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;

    }

}











