package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-05-22 4:32 PM
 */

public class $572_另一棵树的子树 {

    /**
     * https://leetcode.cn/problems/subtree-of-another-tree/
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
     * 如果存在，返回 true ；否则，返回 false 。
     * <p>
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     */
    public static void main(String[] args) {
        $572_另一棵树的子树 l = new $572_另一棵树的子树();
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        root.left = root1;
        root.right = root2;

        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);

        TreeNode root11 = new TreeNode(1);
        TreeNode root21 = new TreeNode(2);
        TreeNode root0 = new TreeNode(0);

        root3.left = root4;
        root3.right = root5;
        root4.left = root11;
        root4.right = root21;
        root21.left = root0;

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode.left = treeNode1;
        boolean subtree = l.isSubtree3(treeNode, new TreeNode(2));
        System.out.println(subtree);
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        StringBuilder subRoots = new StringBuilder();
        traverse(subRoot, subRoots);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    continue;
                }
                StringBuilder temp = new StringBuilder();
                traverse(cur, temp);
                if (temp.toString().equals(subRoots.toString())) {
                    return true;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        return false;
    }

    void traverse(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("-").append("#");
            return;
        }
        s.append("-").append(root.val);
        traverse(root.left, s);
        traverse(root.right, s);
    }


    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if(subRoot == null) {
            return true;
        }

        return isSameTree(root, subRoot) || isSubtree2(root.left, subRoot) || isSubtree2(root.right, subRoot);

    }


    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if(s.val != t.val) {
            return false;
        }

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }


    public boolean isSubtree3(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        StringBuilder s = new StringBuilder();
        traverse1(subRoot, s);
        StringBuilder s1 = new StringBuilder();
        traverse1(root, s1);
        int i = s.toString().indexOf(s1.toString());
        return i >= 0;
    }


    void traverse1(TreeNode root, StringBuilder s) {

        s.append(root.val);
        if (root.left == null) {
            s.append("l#");
        } else {
            traverse1(root.left, s);
        }
        if (root.right == null) {
            s.append("r#");
        } else {
            traverse1(root.right, s);
        }

    }
}






















