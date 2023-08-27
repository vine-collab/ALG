package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.LinkedList;

/**
 * @author 阿季
 * @date 2022-09-01 8:53 PM
 */

public class $297_二叉树的序列化与反序列化 {


    /**
     * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
     */
    public static void main(String[] args) {
        $297_二叉树的序列化与反序列化 e = new $297_二叉树的序列化与反序列化();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t3.left = new TreeNode(4);
        t3.right = new TreeNode(5);
        root.right= t3;
        String serialize = e.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = e.deserialize(serialize);
        System.out.println(deserialize);


    }



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

         this.serialize(root, list);
        return String.join(",", list);
    }

    LinkedList<String> list = new LinkedList<>();


    public void serialize(TreeNode root, LinkedList<String> cur) {
        if(root == null) {
            cur.addLast("#");
            return;
        }

        cur.addLast(String.valueOf(root.val));
        serialize(root.left, cur);
        serialize(root.right, cur);

    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        for (String s : split) {
            list.addLast(s);
        }
        return des();
    }
    public TreeNode des() {
        if(list.isEmpty()) {
            return null;
        }

        String s = list.removeFirst();

        if(s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = des();
        root.right = des();
        return root;
    }
}































































