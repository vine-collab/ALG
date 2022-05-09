package com.vine.alg.二叉树.序列化与反序列;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.LinkedList;

/**
 * @author 阿季
 * @date 2022-05-09 9:10 AM
 */

public class 前序遍历 {

    public static void main(String[] args) {
        前序遍历 q = new 前序遍历();
    }

    /*
        void traverse(TreeNode root) {
            if(root == null) return null;

            traverse(root.left);
            traverse(root.right);
        }
     */

    /*
    先序遍历打平二叉树
     */
    LinkedList<String> res = new LinkedList<>();

    void traverse(TreeNode treeNode) {
        if (treeNode == null) {
            // 用# 代替空
            res.addLast("#");
            return;
        }

        traverse(treeNode.left);
        traverse(treeNode.right);
    }


    /*
        还原二叉树
     */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        // 第一个就是根节点
        String first = nodes.removeFirst();
        if (first.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


}
