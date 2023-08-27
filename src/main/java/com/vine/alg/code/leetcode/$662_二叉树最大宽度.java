package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-08-24 9:46 PM
 */

public class $662_二叉树最大宽度 {

    /**
     * https://leetcode.cn/problems/maximum-width-of-binary-tree/
     */
    public static void main(String[] args) {
        $662_二叉树最大宽度 z = new $662_二叉树最大宽度();
        TreeNode root = new TreeNode(1);

        TreeNode l = new TreeNode(3);
        TreeNode r = new TreeNode(2);

        TreeNode ll = new TreeNode(5);
        l.setLeft(ll);
        root.setLeft(l);
        root.setRight(r);

        int i = z.widthOfBinaryTree(root);
        System.out.println(i);


    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 1));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int start = 0, end = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                int id = cur.id;
                TreeNode node = cur.root;

                if (i == 0) {
                    start = id;
                }

                if (i == size - 1) {
                    end = id;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, id * 2));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, id * 2 + 1));
                }


            }
            maxWidth = Math.max(maxWidth, end - start + 1);


        }
        return maxWidth;


    }


    class Pair {
        TreeNode root;
        int id;

        public Pair(TreeNode root, int id) {
            this.id = id;
            this.root = root;
        }

    }
}

































































