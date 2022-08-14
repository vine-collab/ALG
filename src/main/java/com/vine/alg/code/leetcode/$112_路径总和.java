package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.LinkedList;

/**
 * @author 阿季
 * @date 2022-08-14 2:59 PM
 */

public class $112_路径总和 {


    /**
     * https://leetcode.cn/problems/path-sum/
     */
    public static void main(String[] args) {
        $112_路径总和 z = new $112_路径总和();
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traverse(root, new LinkedList<>(), targetSum);
    }



    boolean traverse(TreeNode root, LinkedList<Integer> cur, int targetSum) {

        if (root == null) {
            return false;
        }

        int remain = targetSum - root.val;

        if (root.left == null && root.right == null) {
            if (remain == 0) {
                return true;
            }
        }


        cur.addLast(root.val);
        boolean traverse = traverse(root.left, cur, remain);
        if(traverse) {
            return true;
        }
        cur.removeLast();


        cur.addLast(root.val);
        boolean traverse1 = traverse(root.right, cur, remain);
        if(traverse1) {
            return true;
        }
        cur.removeLast();

        return false;
    }
}































































