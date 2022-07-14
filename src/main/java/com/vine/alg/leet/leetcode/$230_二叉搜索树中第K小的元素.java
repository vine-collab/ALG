package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-13 9:50 PM
 */

public class $230_二叉搜索树中第K小的元素 {

    /**
     * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
     */
    public static void main(String[] args) {
        $230_二叉搜索树中第K小的元素 e = new $230_二叉搜索树中第K小的元素();
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return res;
    }

    int res = 0;
    int k = 0;
    int rank = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right);


    }

}
