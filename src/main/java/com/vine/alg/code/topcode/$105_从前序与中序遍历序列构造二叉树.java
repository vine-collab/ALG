package com.vine.alg.code.topcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.stream.IntStream;

/**
 * @author 阿季
 * @date 2022-08-08 9:33 PM
 */

public class $105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        $105_从前序与中序遍历序列构造二叉树 c = new $105_从前序与中序遍历序列构造二叉树();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {

            return null;
        }
        int curValue = preorder[preStart];
        //  构造根节点
        TreeNode cur = new TreeNode(curValue);
        int curIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if(curValue == inorder[i]) {
                curIndex = i;
                break;
            }
        }

        // 左子树长度
        int leftTreeSize = curIndex - inStart;

        // 构造左子树
        cur.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, curIndex - 1);
        // 构造右子树
        cur.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, curIndex + 1, inEnd);


        return cur;

    }


}




























































