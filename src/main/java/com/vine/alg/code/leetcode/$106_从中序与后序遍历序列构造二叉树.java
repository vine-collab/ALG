package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-08 8:48 AM
 */

public class $106_从中序与后序遍历序列构造二叉树 {


    /**
     * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     */
    public static void main(String[] args) {
        $106_从中序与后序遍历序列构造二叉树 h = new $106_从中序与后序遍历序列构造二叉树();
        TreeNode treeNode = h.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);

    }

    TreeNode buildTree(int[] postorder, int posStart, int posEnd, int[] inorder, int inStart, int inEnd) {


        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[posEnd];

        int inorderIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                inorderIndex = i;
            }

        }

        int leftSize = inorderIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(postorder, posStart, posStart + leftSize - 1, inorder, inStart, inorderIndex - 1);
        root.right = buildTree(postorder, posStart + leftSize, posEnd - 1, inorder, inorderIndex + 1, inEnd);

        return root;
    }


}