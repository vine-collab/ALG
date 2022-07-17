package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-07-17 9:24 PM
 */

public class $103_二叉树的锯齿形层序遍历 {

    /**
     * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
     */
    public static void main(String[] args) {
        $103_二叉树的锯齿形层序遍历 e = new $103_二叉树的锯齿形层序遍历();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (flag) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            flag = !flag;
            res.add(level);


        }

        return res;
    }


}































































