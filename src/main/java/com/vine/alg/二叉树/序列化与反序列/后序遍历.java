package com.vine.alg.二叉树.序列化与反序列;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.LinkedList;

/**
 * @author 阿季
 * @date 2022-05-09 8:13 PM
 */

public class 后序遍历 {

    /*
        void traverse(TreeNode root) {
            if(root == null) return ;
            traverse(root.left);
            traverse(root.right);

            // 后续遍历操作
        }
     */


    LinkedList<String> res = new LinkedList<>();

    void serialize(TreeNode root) {
        if (root == null) {
            res.addLast("#");
            return;
        }
        serialize(root.left);
        serialize(root.right);
        res.addLast(String.valueOf(root.val));

    }


    TreeNode deserialize(LinkedList<String> res) {
        if (res == null || res.isEmpty()) {
            return null;
        }
        String s = res.removeLast();  // 根节点在最后一个元素
        if (s.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.right = deserialize(res);
        treeNode.left = deserialize(res);
        return treeNode;


    }


}
