package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-14 8:46 PM
 */

public class $98_验证二叉搜索树 {
    public static void main(String[] args) {
        $98_验证二叉搜索树 y = new $98_验证二叉搜索树();
        TreeNode preorder = TreeNode.createPreorder("5,1,4,null,null,3,6");
        boolean validBST = y.isValidBST(preorder);
        System.out.println(validBST);


    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    // max.val > root.val > min.val
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

}
