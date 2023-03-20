package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2023-03-20 10:24 PM
 */

public class $538_把二叉搜索树转换为累加树 {


    public static void main(String[] args) {
        $538_把二叉搜索树转换为累加树 l = new $538_把二叉搜索树转换为累加树();


    }


    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }


    int sum = 0;
    void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);

    }




}































































