package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-07-05 9:46 PM
 */

public class $144_二叉树的前序遍历 {

    public static void main(String[] args) {
        $144_二叉树的前序遍历 e = new $144_二叉树的前序遍历();
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    // 回溯思路
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }


    //递归思路
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        res.add(root.val);
        res.addAll(preorderTraversal1(root.left));
        res.addAll(preorderTraversal1(root.right));
        return res;
    }
}









