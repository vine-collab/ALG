package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-14 10:04 PM
 */

public class $450_删除二叉搜索树中的节点 {

    /**
     * https://leetcode.cn/problems/delete-node-in-a-bst/
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 左右子树都存在
            // 寻找右子树的最小值
            TreeNode min = findMin(root.right);
            // 删除右子树的最小节点
            root.right = deleteNode(root.right, min.val);
            // 替换val == key的节点
            min.left = root.left;
            min.right = root.right;
            root = min;

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode findMin(TreeNode root) {


        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
