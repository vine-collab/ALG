package com.hoteach.naive;

import java.util.Stack;

/**
 * 查找二叉树的最大节点
 *
 * @author hekai
 * @create 2017-10-20 下午4:42
 */

public class BinaryTreeMaximumNode {

    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode maxNode = new TreeNode(0);
        while (root != null || !stack.empty()) {
            while (root != null) {
                if (maxNode.val < root.val) {
                    maxNode = root;
                }
                stack.push(root);
                root = root.leftChild;
            }
            root = stack.pop();
            root = root.rightChild;

        }
        return maxNode;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode node1 = new TreeNode(-5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-4);
        TreeNode node6 = new TreeNode(-5);
        TreeNode node7 = new TreeNode(5);
        rootNode.leftChild = node1;
        rootNode.rightChild = node2;

        node1.rightChild = node3;
        node2.leftChild = node4;

        node3.leftChild = node5;
        node4.rightChild = node6;

        node6.leftChild = node7;

        BinaryTreeMaximumNode binaryTreeMaximumNode = new BinaryTreeMaximumNode();
        TreeNode treeNode = binaryTreeMaximumNode.maxNode(rootNode);
        System.out.println(treeNode.val);

    }
}

class TreeNode {
    TreeNode leftChild;
    TreeNode rightChild;
    int val;

    TreeNode(int x) {
        val = x;
    }
}
