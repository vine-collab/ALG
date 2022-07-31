package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-31 4:57 PM
 */

public class $100_相同的树 {


    /**
     * https://leetcode.cn/problems/same-tree/
     */
    public static void main(String[] args) {
        $100_相同的树 x = new $100_相同的树();
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


}































































