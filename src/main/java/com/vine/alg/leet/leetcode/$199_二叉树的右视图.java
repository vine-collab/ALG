package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-07-24 6:15 PM
 */

public class $199_二叉树的右视图 {


    /**
     * https://leetcode.cn/problems/binary-tree-right-side-view/
     */
    public static void main(String[] args) {
        $199_二叉树的右视图 y = new $199_二叉树的右视图();

    }

    List<Integer> res = new ArrayList<>();

    /**
     * 返回root子树的右视图
     */
    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return res;

    }

    void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode cur = q.peek();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();

                if (poll.right != null) {
                    q.offer(poll.right);
                }

                if (poll.left != null) {
                    q.offer(poll.left);
                }
            }
            res.add(cur.val);
        }
    }


}































































