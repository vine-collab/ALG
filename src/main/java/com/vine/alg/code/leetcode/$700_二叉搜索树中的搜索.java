package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-14 9:26 PM
 */

public class $700_二叉搜索树中的搜索 {


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }


        if (root.val > val) {
            return searchBST(root.left, val);
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }

        return root;
    }

}
