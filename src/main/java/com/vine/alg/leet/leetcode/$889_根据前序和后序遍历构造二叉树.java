package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-10 3:21 PM
 */

public class $889_根据前序和后序遍历构造二叉树 {


    public static void main(String[] args) {
        $889_根据前序和后序遍历构造二叉树 g = new $889_根据前序和后序遍历构造二叉树();
        TreeNode treeNode = g.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println(treeNode);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

    }

    TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // 根节点
        int rootVal = preorder[preStart];
        // 根的左节点
        int rootLeftVal = preorder[preStart + 1];
        // 获取左子树根节点在后续的位置
        int postLeftIndex = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == rootLeftVal) {
                postLeftIndex = i;
                break;
            }
        }
        // 计算左子树的个数
        int leftSize = postLeftIndex - postStart + 1;
        // 当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 构造左子树
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, postorder, postStart, postLeftIndex);
        // 构造右子树
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, postorder, postLeftIndex + 1, postEnd - 1);
        return root;

    }


}
