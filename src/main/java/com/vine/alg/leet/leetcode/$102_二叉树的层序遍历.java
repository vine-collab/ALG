package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-07-26 11:09 PM
 */

public class $102_二叉树的层序遍历 {

    /**
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/
     */
    public static void main(String[] args) {
        $102_二叉树的层序遍历 $102_二叉树的层序遍历 = new $102_二叉树的层序遍历();
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                subRes.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            res.add(subRes);
        }

        return res;
    }
}






























































