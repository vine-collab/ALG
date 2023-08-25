package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2023-08-24 09:04
 */

public class $958_二叉树的完全性检验 {


    /**
     * 给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
     * <p>
     * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [1,2,3,4,5,6]
     * 输出：true
     * 解释：最后一层前的每一层都是满的（即，节点值为 {1} 和 {2,3} 的两层），且最后一层中的所有节点（{4,5,6}）尽可能靠左。
     * 示例 2：
     * <p>
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：false
     * 解释：值为 7 的节点不满足条件「节点尽可能靠左」。
     * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
     */
    public static void main(String[] args) {
        $958_二叉树的完全性检验 z = new $958_二叉树的完全性检验();
    }


    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isNull = false;
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(isNull && cur != null) {
                    return false;
                }
                if(cur == null) {
                    isNull = true;
                    continue;
                }

                queue.offer(cur.left);
                queue.offer(cur.right);
            }

        }
        return true;


    }





}































































