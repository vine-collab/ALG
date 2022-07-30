package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-30 3:58 PM
 */

public class $129_求根节点到叶节点数字之和 {

    public static void main(String[] args) {
        $129_求根节点到叶节点数字之和 q = new $129_求根节点到叶节点数字之和();
    }


    StringBuilder path = new StringBuilder();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        // 遍历一遍二叉树就能出结果
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置，记录节点值
        path.append(root.val);
        if (root.left == null && root.right == null) {
            // 到达叶子节点，累加路径和
            res += Integer.parseInt(path.toString());
        }
        // 二叉树递归框架，遍历左右子树
        traverse(root.left);
        traverse(root.right);

        // 后续遍历位置，撤销节点值
        path.deleteCharAt(path.length() - 1);

    }

}































































