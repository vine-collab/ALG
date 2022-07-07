package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-07 9:36 PM
 */

public class $105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        $105_从前序与中序遍历序列构造二叉树 z = new $105_从前序与中序遍历序列构造二叉树();
        TreeNode treeNode = z.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {


        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];

        int inorderIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                inorderIndex = i;
            }

        }

        int leftSize = inorderIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inorderIndex - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, inorderIndex + 1, inEnd);

        return root;
    }


}
