package com.vine.alg.二叉树.序列化与反序列;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-05-09 8:32 PM
 */

public class 层次遍历 {

    /*
        层次遍历框架

        void traverse(TreeNode root) {
            if(root == null) return;

            Queue q = new Queue();
            q.offer(root);

            while(!q.isEmpty) {
                TreeNode cur = q.poll();
                // 遍历代码逻辑

                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
     */

    LinkedList<String> res = new LinkedList<>();

    void serialize(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            if(poll == null) {
                res.addLast("#");
                continue;
            }
            res.addLast(String.valueOf(poll.val));

            q.offer(poll.left);
            q.offer(poll.right);
        }
    }


    TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes == null || nodes.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(nodes.getFirst());
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < nodes.size();) {
            // q中的节点都是父节点
            TreeNode parent = q.poll();
            // 父节点对应左侧子节点的值
            String left = nodes.get(i++);
            if(!left.equals("#")) {
                parent.left = new TreeNode(left);
                q.offer(parent.left);
            } else {
//                parent.left == null;
            }
            // 父节点对应左侧子节点的值
            String right = nodes.get(i++);
            if(!right.equals("#")) {
                parent.right = new TreeNode(left);
                q.offer(parent.right);
            } else {
//                parent.right == null;
            }

        }
        return root;

    }

}




























